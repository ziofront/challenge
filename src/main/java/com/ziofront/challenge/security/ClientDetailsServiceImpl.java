package com.ziofront.challenge.security;

import com.ziofront.challenge.repository.ClientRepository;
import com.ziofront.challenge.service.impl.KakaoPlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private static Logger LOG = LoggerFactory.getLogger(ClientDetailsServiceImpl.class);

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        ClientDetailsImpl client = clientRepository.findByClientId(clientId);
        String resourceIds = client.getResourceIds().stream().collect(Collectors.joining(","));
        String scopes = client.getScope().stream().collect(Collectors.joining(","));
        String grantTypes = client.getAuthorizedGrantTypes().stream().collect(Collectors.joining(","));
        String authorities = client.getAuthorities().stream().map(g -> g.getAuthority()).collect(Collectors.joining(","));

        LOG.debug("resourceIds={}",resourceIds);
        LOG.debug("scopes={}",scopes);
        LOG.debug("grantTypes={}",grantTypes);
        LOG.debug("authorities={}",authorities);



        BaseClientDetails base = new BaseClientDetails(client.getClientId(), resourceIds, scopes, grantTypes, authorities);
        base.setClientSecret(client.getClientSecret());
        base.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
        base.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());
        base.setAdditionalInformation(client.getAdditionalInformation());
        base.setAutoApproveScopes(client.getScope());


        LOG.debug("base={}",base);

        return base;
    }
}

package com.ziofront.challenge;

import com.ziofront.challenge.repository.ClientRepository;
import com.ziofront.challenge.security.ClientDetailsImpl;
import com.ziofront.challenge.service.MemberService;
import com.ziofront.challenge.vo.Member;
import com.ziofront.challenge.vo.MemberRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author jiho
 */
@Component
public class ApplicationTestDataLoader implements ApplicationRunner {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public ApplicationTestDataLoader(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        memberService.saveMember(Member.builder().name("라이언").loginId("test1").loginPassword("1024").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());
        memberService.saveMember(Member.builder().name("무지").loginId("test2").loginPassword("2048").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());
        memberService.saveMember(Member.builder().name("네오").loginId("test3").loginPassword("4096").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());

//        createOauthClients();

    }

    static final String GRANT_TYPE_PASSWORD = "password";
    static final String AUTHORIZATION_CODE = "authorization_code";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String IMPLICIT = "implicit";
    static final String SCOPE_READ = "read";
    static final String SCOPE_WRITE = "write";
    static final String TRUST = "trust";

    private void createOauthClients() {

        ClientDetailsImpl client = new ClientDetailsImpl();
        client.setId("someId");

        client.setResourceIds(new HashSet<>(Arrays.asList("resource_id")));
        client.setClientId("client");
        client.setClientSecret("clientsecret");
//        client.setAuthorizedGrantTypes(new HashSet<>(Arrays.asList(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT)));
        client.setAuthorizedGrantTypes(new HashSet<>(Arrays.asList(GRANT_TYPE_PASSWORD)));
        client.setScope(new HashSet<>(Arrays.asList(SCOPE_READ, SCOPE_WRITE, TRUST)));
        client.setSecretRequired(true);
        client.setAccessTokenValiditySeconds(50000);
        client.setRefreshTokenValiditySeconds(50000);
        client.setScoped(false);

        clientRepository.save(client);
    }
}

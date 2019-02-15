package com.ziofront.challenge.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@Entity
public class ClientDetailsImpl implements ClientDetails {

    @Id
    @NotNull
    @Getter
    @Setter
    private String id;

    @NotNull
    @Getter
    @Setter
    private String clientId;

    @Getter
    @Setter
    private String clientSecret;

    @Getter
    @Setter
    private Integer accessTokenValiditySeconds;

    @Getter
    @Setter
    private Integer refreshTokenValiditySeconds;

    @Getter
    @Setter
    private boolean secretRequired;

    @Getter
    @Setter
    private boolean scoped;

    @Getter
    @Setter
    private boolean autoApprove;

    @Getter
    @Setter
    @Column(name = "RESOURCE_IDS")
    private String resourceIds2;

    @Getter
    @Setter
    @Column(name = "SCOPE")
    private String scope2;

    @Getter
    @Setter
    @Column(name = "AUTH_GRANT_TYPE")
    private String authorizedGrantTypes2;

    @Getter
    @Setter
    @Column(name = "REDIRECT_URI")
    private String registeredRedirectUri2;

    @Getter
    @Transient
    private Set<String> resourceIds = new HashSet<>();

    @Getter
    @Transient
    private Set<String> scope = new HashSet<>();

    @Getter
    @Transient
    private Set<String> authorizedGrantTypes = new HashSet<>();

    @Getter
    @Setter
    @Transient
    private Set<String> registeredRedirectUri = new HashSet<>();

    @Getter
    @Setter
    @Transient
    private Collection<GrantedAuthority> authorities = new HashSet<>();

    @Getter
    @Setter
    @Transient
    private Map<String, Object> mapAdditionalInformation = new HashMap<>();


    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

    public void setAdditionalInformation(Map<String, Object> ii) {
    }

    public boolean isAutoApprove(String scope) {
        return Boolean.parseBoolean(scope);
    }

    public void setResourceIds(Set<String> resourceIds) {
        this.resourceIds = resourceIds;
        this.resourceIds2 = resourceIds.stream().collect(Collectors.joining(","));
    }

    public void setScope(Set<String> scope) {
        this.scope = scope;
        this.scope2 = scope.stream().collect(Collectors.joining(","));
    }

    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.authorizedGrantTypes2 = authorizedGrantTypes.stream().collect(Collectors.joining(","));
    }

    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
        this.registeredRedirectUri2 = registeredRedirectUri.stream().collect(Collectors.joining(","));
    }

}

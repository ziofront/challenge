package com.ziofront.challenge.web.controller.rest;

import com.ziofront.challenge.security.AuthenticationRequest;
import com.ziofront.challenge.security.AuthenticationToken;
import com.ziofront.challenge.service.MemberService;
import com.ziofront.challenge.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private static Logger LOG = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthenticationToken login(
            @RequestBody AuthenticationRequest authenticationRequest,
            HttpSession session) {

        String loginId = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        LOG.debug("loginId={}, password={}", loginId, password);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginId, password);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        Member member = memberService.getMember(loginId);
        LOG.debug("member={}", member);

        return AuthenticationToken.builder().username(loginId).authorities(member.getRoles()).token(session.getId()).build();
    }
}

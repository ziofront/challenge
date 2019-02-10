package com.ziofront.challenge.web.interceptor;

import com.ziofront.challenge.security.UserDetailsImpl;
import com.ziofront.challenge.service.PlaceFindHIstoryService;
import com.ziofront.challenge.vo.Member;
import com.ziofront.challenge.vo.PlaceFindHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PlaceFindHistoryInterceptor extends HandlerInterceptorAdapter {

    private static Logger LOG = LoggerFactory.getLogger(PlaceFindHistoryInterceptor.class);

    @Autowired
    PlaceFindHIstoryService placeFindHIstoryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetailsImpl userDetails = (UserDetailsImpl) principal;

        LOG.debug("userDetails={}", userDetails);

        final Member member = ((UserDetailsImpl) principal).getMember();
        final String keyword = request.getParameter("keyword");

        LOG.debug("keyword={}", keyword);

        PlaceFindHistory placeFindHistory = PlaceFindHistory.builder().keyword(keyword).memberSeq(member.getSeq()).build();

        placeFindHIstoryService.saveHistory(placeFindHistory);


    }
}

package st.bdd.work.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import st.bdd.work.work.dto.AccessTokenDto;
import st.bdd.work.work.provider.GithubProvider;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String Callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id("41d94ed120546bb33cdb");
        accessTokenDto.setClient_secret("f47226cd3a973e37e2387ba28d21b218aa45e230");
        githubProvider.getAccessToken(accessTokenDto);
        return "index";
    }
}

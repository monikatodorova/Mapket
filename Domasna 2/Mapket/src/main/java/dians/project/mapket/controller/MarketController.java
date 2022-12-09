package dians.project.mapket.controller;

import dians.project.mapket.service.impl.MarketServiceImpl;
import dians.project.mapket.service.impl.MunicipalityServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class MarketController {
    public final MarketServiceImpl marketsService;
    public final MunicipalityServiceImpl municipalityService;

    public MarketController(MarketServiceImpl marketsService, MunicipalityServiceImpl municipalityService) {
        this.marketsService = marketsService;
        this.municipalityService = municipalityService;
    }

    @GetMapping("/home")
    public String homePage(@RequestParam(required = false) String marketName,
                           Model model) {
        model.addAttribute("markets", marketsService.findAll());
        model.addAttribute("municipalities", municipalityService.findAll());
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/markets")
    public String marketsPage(@RequestParam(required = false) String marketName,
                              @RequestParam(required = false) String municipalityId,
                           Model model) {
        if(municipalityId==null && marketName==null) {
            model.addAttribute("markets", marketsService.findAll());
            model.addAttribute("municipalities", municipalityService.findAll());
            return "markets";
        }

        Long munId= Long.valueOf(0);
        if(!municipalityId.equals("0")) munId= Long.valueOf(municipalityId);

        // ako name="" i munId=0 -> prikazi gi site
        if(marketName.equals("") && munId==0) {
            model.addAttribute("markets", marketsService.findAll());
        }
        // ako name="name" i munId=0
        if(!marketName.equals("") && munId==0) {
            model.addAttribute("markets", marketsService.findByName(marketName));
        }
        // ako name="name" i munId=id
        if(!marketName.equals("") && munId!=0) {
            model.addAttribute("markets", marketsService.findByNameAndMunicipality(marketName, munId));
        }
        // ako name="" i munId=id
        if(marketName.equals("") && munId!=0) {
            model.addAttribute("markets", marketsService.findByMunicipality(munId));
        }

        model.addAttribute("municipalities", municipalityService.findAll());
        return "markets";
    }

}

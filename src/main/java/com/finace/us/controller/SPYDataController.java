package com.finace.us.controller;

import com.finace.us.domain.SPYDataEntry;
import com.finace.us.service.SPYDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class SPYDataController {
    @Autowired
    private SPYDataService spyDataService;

    @GetMapping("/spy")
    public List<SPYDataEntry> getSPYData() throws IOException {
        return spyDataService.getSPYData();
    }


}

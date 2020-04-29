package io.openslice.tmf.sac640.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T12:42:32.118457300+03:00[Europe/Athens]")
@Controller("ServiceApiController640")
@RequestMapping("/ServiceActivationAndConfiguration/v3/")
public class ServiceApiController extends io.openslice.tmf.sim638.api.ServiceApiController{

	

	@Autowired
	public ServiceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		super(objectMapper, request);
	}

}

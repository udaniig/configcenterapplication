package com.mds.configcenter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.configcenter.exception.ResourceNotFoundException;
import com.mds.configcenter.model.PricePlan;
import com.mds.configcenter.repository.PricePlanRepository;

@RestController
@RequestMapping("/api/v1/")
public class PricePlanController {
	@Autowired
	private PricePlanRepository pricePlanRepository;
	
	//get all priceplans REST API
	@GetMapping("/priceplans")
	public List<PricePlan> getPriceplans(){
		return pricePlanRepository.findAll();
	}
	
	//Create Price Plan Rest API
	@PostMapping("/priceplans")
	public PricePlan createPricePlan(@RequestBody PricePlan pricePlan){
		return pricePlanRepository.save(pricePlan);
	}
	
	//get Priceplan by ID REST API
	@GetMapping("/priceplans/{id}")
	public ResponseEntity<PricePlan> getPricePlanById(@PathVariable Long id){
		PricePlan pricePlan = pricePlanRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Price plan not found with id" + id));
		return ResponseEntity.ok(pricePlan);
	}
	
	//Update priceplan REST API
	@PutMapping("/priceplans/{id}")
	public ResponseEntity<PricePlan> updatePricePlan(@PathVariable Long id, @RequestBody PricePlan pricePlanDetails){
		PricePlan pricePlan = pricePlanRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Price plan not found with id" + id));
		pricePlan.setPricePlanName(pricePlanDetails.getPricePlanName());
		pricePlan.setDescription(pricePlanDetails.getDescription());
		pricePlan.setFeatures(pricePlanDetails.getFeatures());
		PricePlan updatedPricePlan = pricePlanRepository.save(pricePlan);
		return ResponseEntity.ok(updatedPricePlan);
	}
	
	//Delete priceplan REST API
	@DeleteMapping("/priceplans/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePricePlan(@PathVariable Long id){
		PricePlan pricePlan = pricePlanRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Price plan not found with id" + id));
		pricePlanRepository.delete(pricePlan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	} 
}

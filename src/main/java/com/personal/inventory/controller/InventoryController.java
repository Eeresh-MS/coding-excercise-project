package com.personal.inventory.controller;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.inventory.model.InventoryModel;

@Controller
public class InventoryController {

	@GetMapping("getForm")
	public String getForm() {
		return "inventoryForm";
	}

	@PostMapping("/saveDetails")
	public String saveDetails(
			@ModelAttribute("inventoryModel") InventoryModel inventoryModel,
			ModelMap modelMap) {
		modelMap.put("name", inventoryModel.getName());
		modelMap.put("serialNumber", inventoryModel.getSerialNumber());
		modelMap.put("value", inventoryModel.getValue());
		saveDataToJsonFile(inventoryModel);
		return "viewDetails";
	}

	private void saveDataToJsonFile(InventoryModel inventoryModel) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("PIDetailsFile.json"), inventoryModel);
			String jsonInString = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(inventoryModel);
			System.out.println(jsonInString);
			System.out.println(
					"Added Inventory details to the JSON file Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@PostMapping("/printJsonFileDataToHtml")
	public String printJsonFileDataToHtml(String fileName,
			ModelMap modelMap) {
		ObjectMapper objectMapper = new ObjectMapper();
		InventoryModel inventoryModelObject = new InventoryModel();
		try {
			inventoryModelObject = objectMapper.readValue(
					new File("PIDetailsFile.json"),
					InventoryModel.class);
			modelMap.put("name", inventoryModelObject.getName());
			modelMap.put("serialNumber",
					inventoryModelObject.getSerialNumber());
			NumberFormat currencyFormatter = NumberFormat
					.getCurrencyInstance(new Locale("en", "US"));
			modelMap.put("value",
					currencyFormatter.format(inventoryModelObject.getValue()));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "viewDetailsFromJsonFile";
	}
}

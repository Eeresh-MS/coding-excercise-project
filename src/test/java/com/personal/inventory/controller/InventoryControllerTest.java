package com.personal.inventory.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.personal.inventory.model.InventoryModel;

class InventoryControllerTest {

	@Before
	public void init() {
		InventoryModel inventoryModel = new InventoryModel();
		inventoryModel.setName("Sony");
		inventoryModel.setSerialNumber("as5454dsdseqw4");
		inventoryModel.setValue(6566464);
	}

	@Test
	void test() {

	}



}

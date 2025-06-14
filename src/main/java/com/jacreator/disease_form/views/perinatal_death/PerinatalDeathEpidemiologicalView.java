package com.jacreator.disease_form.views.perinatal_death;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class PerinatalDeathEpidemiologicalView extends VerticalLayout {
  private static final List<String> facilityData = Arrays.asList(
      "Federal Medical Center", "Jabi Clinic");

  public PerinatalDeathEpidemiologicalView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Complete Address
    TextField clientAddress = new TextField("Complete Address");
    clientAddress.setPlaceholder("Enter Address");

    // Facility Type
    ComboBox<String> facilityType = new ComboBox<>("Type");
    facilityType.setItems(facilityData);
    facilityType.setPlaceholder("Select Facility Type");
    facilityType.setRequired(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    form.add(clientAddress, facilityType);

    return form;
  }
}

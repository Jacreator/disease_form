package com.jacreator.disease_form.views.buruliUlcer;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class BuruliUlcerReferralView extends VerticalLayout {

  private final List<String> nameOfTestingLaboratory = Arrays.asList(
      "National Reference Laboratory (NRL)",
      "Central Public Health Laboratory (CPHL)");
  private final List<String> stateData = Arrays.asList("FCT", "Enugu");
  private final List<String> fctLgas = Arrays.asList("AMAC", "Bwari", "Kwali");
  private final List<String> enuguLgas = Arrays.asList("Nsukka", "Enugu south", "Udi");

  public BuruliUlcerReferralView() {
    setWidthFull();
    
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Treatment
    RadioButtonGroup<String> treatment = new RadioButtonGroup<>();
    treatment.setLabel("Treatment");
    treatment.setItems("Yes", "No");
    treatment.setRequired(true);

    // If Yes, Name Of Facility
    TextField specifyNameOfFacility = new TextField("If Yes, Name Of Facility");
    specifyNameOfFacility.setPlaceholder("Specify Facility");
    specifyNameOfFacility.setVisible(false);

    // State Of Residence
    ComboBox<String> stateOfResidence = new ComboBox<>("State Of Residence");
    stateOfResidence.setItems(stateData);
    stateOfResidence.setRequired(true);

    // LGA Of Residence
    ComboBox<String> lgaOfResidence = new ComboBox<>("LGA Of Residence");
    lgaOfResidence.setRequired(true);

    // Referral Date
    DatePicker referralDate = new DatePicker("Referral Date");
    referralDate.setMax(LocalDate.now());
    referralDate.setRequired(true);

    // Dynamic logic: Show facility name only if treatment is "Yes"
    treatment.addValueChangeListener(e -> {
      boolean show = "Yes".equals(e.getValue());
      specifyNameOfFacility.setVisible(show);
    });

    // Dynamic logic: Update LGA options based on state
    stateOfResidence.addValueChangeListener(e -> {
      String state = e.getValue();
      if ("FCT".equals(state)) {
        lgaOfResidence.setItems(fctLgas);
      } else if ("Enugu".equals(state)) {
        lgaOfResidence.setItems(enuguLgas);
      } else {
        lgaOfResidence.clear();
        lgaOfResidence.setItems();
      }
    });

    // Add all fields to the form
    form.add(treatment, specifyNameOfFacility);
    form.add(stateOfResidence, lgaOfResidence);
    form.add(referralDate);

    return form;
  }
}

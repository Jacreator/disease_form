package com.jacreator.disease_form.views.afp;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class EpidemiologicalView extends VerticalLayout {
  public EpidemiologicalView() {
    FormLayout form = new FormLayout();

    RadioButtonGroup<String> polioVaccineStatus = new RadioButtonGroup<>();
    polioVaccineStatus.setLabel("Have you been vaccinated?");
    polioVaccineStatus.setItems("Yes", "No", "Unknown");

    RadioButtonGroup<String> numberOfDoses = new RadioButtonGroup<>();
    numberOfDoses.setLabel("Total Number of polio vaccine doses, exclude dose at birth");
    numberOfDoses.setItems("1", "2", "3", "4", "5+");

    RadioButtonGroup<String> vaccinationHistory = new RadioButtonGroup<>();
    vaccinationHistory.setLabel("Source of RI Vaccination information");
    vaccinationHistory.setItems("Card", "Recall");

    RadioButtonGroup<String> opvRiNumber = new RadioButtonGroup<>();
    opvRiNumber.setLabel("Total OPV doses received through RI");
    opvRiNumber.setItems("1", "2", "3", "4", "5+");

    RadioButtonGroup<String> opvSiaNumber = new RadioButtonGroup<>();
    opvSiaNumber.setLabel("Total OPV doses received through SIA");
    opvSiaNumber.setItems("1", "2", "3", "4", "5+");

    RadioButtonGroup<String> ipvRiNumber = new RadioButtonGroup<>();
    ipvRiNumber.setLabel("Total IPV doses received through RI");
    ipvRiNumber.setItems("1", "2", "3", "4", "5+");

    RadioButtonGroup<String> ipvSiaNumber = new RadioButtonGroup<>();
    ipvSiaNumber.setLabel("Total IPV doses received through SIA");
    ipvSiaNumber.setItems("1", "2", "3", "4", "5+");

    DatePicker ipvDoseDate = new DatePicker("Date of last IPV dose received through SIA");
    DatePicker opvDoseDate = new DatePicker("Date of last OPV dose received through SIA");

    TextField helpHistory1 = new TextField(
        "Where has the child been seeking help for this problem before presenting at present place");
    DatePicker helpHistoryDate1 = new DatePicker("Date (1)");

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    form.add(
        polioVaccineStatus, numberOfDoses, vaccinationHistory, opvRiNumber, opvSiaNumber,
        ipvRiNumber, ipvSiaNumber, ipvDoseDate, opvDoseDate,
        helpHistory1, helpHistoryDate1);

    // AccordionPanel panel = accordion.add("Epidemiological Information", form);
    add(form);
  }
}

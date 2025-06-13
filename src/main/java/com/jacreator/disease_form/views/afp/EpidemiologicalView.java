package com.jacreator.disease_form.views.afp;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class EpidemiologicalView extends VerticalLayout {
  public EpidemiologicalView() {
    Accordion accordion = new Accordion();
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
        "Where has the child been seeking help for this problem before presenting at present place (1)");
    DatePicker helpHistoryDate1 = new DatePicker("Date (1)");
    TextField helpHistory2 = new TextField("Where has the child been seeking help for this problem (2)");
    DatePicker helpHistoryDate2 = new DatePicker("Date (2)");
    TextField helpHistory3 = new TextField("Where has the child been seeking help for this problem (3)");
    DatePicker helpHistoryDate3 = new DatePicker("Date (3)");

    form.add(
        polioVaccineStatus, numberOfDoses, vaccinationHistory, opvRiNumber, opvSiaNumber,
        ipvRiNumber, ipvSiaNumber, ipvDoseDate, opvDoseDate,
        helpHistory1, helpHistoryDate1, helpHistory2, helpHistoryDate2, helpHistory3, helpHistoryDate3);

    // AccordionPanel panel = accordion.add("Epidemiological Information", form);
    add(form);
  }
}

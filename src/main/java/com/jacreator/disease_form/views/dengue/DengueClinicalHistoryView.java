package com.jacreator.disease_form.views.dengue;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class DengueClinicalHistoryView extends VerticalLayout {
  private RadioButtonGroup<String> fever;
  private RadioButtonGroup<String> jaundice;
  private RadioButtonGroup<String> generalWeakness;
  private RadioButtonGroup<String> bleedingFromBodySites;
  private RadioButtonGroup<String> headache;
  private RadioButtonGroup<String> vomiting;
  private RadioButtonGroup<String> rash;
  private TextField otherSymptoms;
  private DatePicker dateOfOnset;

  public DengueClinicalHistoryView() {
    setWidthFull();
    setPadding(true);
    setSpacing(true);

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    form.setWidthFull();
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("900px", 3));

    fever = new RadioButtonGroup<>("Fever");
    fever.setItems("yes", "no", "unknown");
    fever.setRequired(true);
    fever.setRequiredIndicatorVisible(true);

    jaundice = new RadioButtonGroup<>("Jaundice");
    jaundice.setItems("yes", "no", "unknown");
    jaundice.setRequired(true);
    jaundice.setRequiredIndicatorVisible(true);

    generalWeakness = new RadioButtonGroup<>("General weakness");
    generalWeakness.setItems("yes", "no", "unknown");
    generalWeakness.setRequired(true);
    generalWeakness.setRequiredIndicatorVisible(true);

    bleedingFromBodySites = new RadioButtonGroup<>("Bleeding from the nose, gums, skin or GI tract");
    bleedingFromBodySites.setItems("yes", "no", "unknown");
    bleedingFromBodySites.setRequired(true);
    bleedingFromBodySites.setRequiredIndicatorVisible(true);

    headache = new RadioButtonGroup<>("Headache");
    headache.setItems("yes", "no", "unknown");
    headache.setRequired(true);
    headache.setRequiredIndicatorVisible(true);

    vomiting = new RadioButtonGroup<>("Vomiting");
    vomiting.setItems("yes", "no", "unknown");
    vomiting.setRequired(true);
    vomiting.setRequiredIndicatorVisible(true);

    rash = new RadioButtonGroup<>("Rash");
    rash.setItems("yes", "no", "unknown");
    rash.setRequired(true);
    rash.setRequiredIndicatorVisible(true);

    otherSymptoms = new TextField("Other symptoms, please specify");
    otherSymptoms.setPlaceholder("Other symptoms");

    dateOfOnset = new DatePicker("Date Of symptom onset");
    dateOfOnset.setRequired(true);
    dateOfOnset.setRequiredIndicatorVisible(true);
    dateOfOnset.setMax(LocalDate.now());

    form.add(
        fever,
        jaundice,
        generalWeakness,
        bleedingFromBodySites,
        headache,
        vomiting,
        rash,
        otherSymptoms,
        dateOfOnset);

    return form;
  }
}

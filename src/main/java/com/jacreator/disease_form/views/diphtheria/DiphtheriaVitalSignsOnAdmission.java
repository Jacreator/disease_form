package com.jacreator.disease_form.views.diphtheria;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class DiphtheriaVitalSignsOnAdmission extends VerticalLayout {
  private TextField pulseOximetry;
  private TextField pulseRate;
  private TextField respiratoryRate;
  private TextField weight;
  private TextField temp;
  private TextField randomBloodSugar;
  private DatePicker dateOfAdmission;

  public DiphtheriaVitalSignsOnAdmission() {
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

    pulseOximetry = new TextField("Pulse oximetry");
    pulseOximetry.setRequired(true);
    pulseOximetry.setRequiredIndicatorVisible(true);
    pulseOximetry.setPattern("\\d*");

    pulseRate = new TextField("Pulse Rate");
    pulseRate.setRequired(true);
    pulseRate.setRequiredIndicatorVisible(true);
    pulseRate.setPattern("\\d*");

    respiratoryRate = new TextField("Respiratory Rate");
    respiratoryRate.setRequired(true);
    respiratoryRate.setRequiredIndicatorVisible(true);
    respiratoryRate.setPattern("\\d*");

    weight = new TextField("Weight");
    weight.setRequired(true);
    weight.setRequiredIndicatorVisible(true);
    weight.setPattern("\\d*");

    temp = new TextField("Temp");
    temp.setRequired(true);
    temp.setRequiredIndicatorVisible(true);
    temp.setPattern("\\d*");

    randomBloodSugar = new TextField("Random Blood Sugar");
    randomBloodSugar.setRequired(true);
    randomBloodSugar.setRequiredIndicatorVisible(true);
    randomBloodSugar.setPattern("\\d*");

    dateOfAdmission = new DatePicker("Date of admission");
    dateOfAdmission.setRequired(true);
    dateOfAdmission.setRequiredIndicatorVisible(true);
    dateOfAdmission.setMax(LocalDate.now());

    form.add(
        pulseOximetry,
        pulseRate,
        respiratoryRate,
        weight,
        temp,
        randomBloodSugar,
        dateOfAdmission);

    return form;
  }
}

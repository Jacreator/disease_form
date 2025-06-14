package com.jacreator.disease_form.views.tetanus;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TetanusLaboratoryInformationView extends VerticalLayout {
  public TetanusLaboratoryInformationView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Date of response for supplemental
    DatePicker dateOfResponseForSupplement = new DatePicker("Date of response for supplemental");
    dateOfResponseForSupplement.setMax(LocalDate.now());
    dateOfResponseForSupplement.setRequired(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    form.add(dateOfResponseForSupplement);

    return form;
  }
}

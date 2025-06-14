package com.jacreator.disease_form.views.mpox;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class MpoxFinalClassificationView extends VerticalLayout {
  public MpoxFinalClassificationView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Final classification options
    RadioButtonGroup<String> finalClassification = new RadioButtonGroup<>();
    finalClassification.setLabel("Final classification");
    finalClassification.setItems("Confirmed", "Not a Case", "Pending");
    finalClassification.setRequired(true);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    // Add field to the form
    form.add(finalClassification);

    return form;
  }
}

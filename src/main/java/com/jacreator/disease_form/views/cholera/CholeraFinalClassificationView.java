package com.jacreator.disease_form.views.cholera;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class CholeraFinalClassificationView extends VerticalLayout {
  public CholeraFinalClassificationView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Final classification
    RadioButtonGroup<String> finalClassification = new RadioButtonGroup<>();
    finalClassification.setItems("Confirmed", "Probable", "Not a case");
    finalClassification.setRequired(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add field to the form
    form.add(finalClassification, 3);

    return form;
  }
}

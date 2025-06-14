package com.jacreator.disease_form.views.ebola;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class EbolaFinalClassificationView extends VerticalLayout {
  private RadioButtonGroup<String> finalClassification;

  public EbolaFinalClassificationView() {
    setWidthFull();
    setPadding(true);
    setSpacing(true);

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    form.setWidthFull();

    finalClassification = new RadioButtonGroup<>("Final Classification");
    finalClassification.setItems("Confirmed", "Not a case", "Probable", "Pending");
    finalClassification.setRequired(true);
    finalClassification.setRequiredIndicatorVisible(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    form.add(finalClassification);

    return form;
  }
}

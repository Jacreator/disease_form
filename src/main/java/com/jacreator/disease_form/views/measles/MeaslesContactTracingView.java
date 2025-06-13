package com.jacreator.disease_form.views.measles;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class MeaslesContactTracingView extends VerticalLayout {
  public MeaslesContactTracingView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Complete Address
    TextField completeAddress = new TextField("Complete Address");
    completeAddress.setPlaceholder("Enter Address");
    completeAddress.setRequired(true);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("800px", 2));

    form.add(completeAddress);

    return form;
  }
}

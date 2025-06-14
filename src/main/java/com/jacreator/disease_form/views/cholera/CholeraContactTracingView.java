package com.jacreator.disease_form.views.cholera;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CholeraContactTracingView extends VerticalLayout {
  public CholeraContactTracingView() {
    setWidthFull();
    setPadding(true);
    setSpacing(true);
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Complete Address
    TextField clientAddress = new TextField("Complete Address");
    clientAddress.setPlaceholder("Enter Address");
    clientAddress.setRequired(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add field to the form
    form.add(clientAddress);

    return form;
  }
}

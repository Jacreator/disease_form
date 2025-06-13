package com.jacreator.disease_form.views.guinea_worm;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class GuineaWormContactTracingView extends VerticalLayout {
  public GuineaWormContactTracingView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Complete Address
    TextField clientAddress = new TextField("Complete Address");
    clientAddress.setPlaceholder("Enter Address");

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1));

    // Add field to the form
    form.add(clientAddress);

    return form;
  }
}

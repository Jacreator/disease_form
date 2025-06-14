package com.jacreator.disease_form.views.noma;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class NOMAContactTracingView extends VerticalLayout {
  public NOMAContactTracingView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Complete Address
    TextField clientAddress = new TextField("Complete Address");
    clientAddress.setPlaceholder("Enter Address");

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    form.add(clientAddress);

    return form;
  }
}

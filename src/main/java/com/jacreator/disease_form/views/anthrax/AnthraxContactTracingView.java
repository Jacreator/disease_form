package com.jacreator.disease_form.views.anthrax;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class AnthraxContactTracingView extends VerticalLayout {

  public AnthraxContactTracingView() {
 // Open by default if you want: accordion.open(0);
    add(createForm());
  }

  private FormLayout createForm() {
    FormLayout formLayout = new FormLayout();

    // Complete address field
    TextField address = new TextField("Complete address");
    address.setPlaceholder("Enter Address");
    formLayout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    formLayout.add(address);

    return formLayout;
  }
}

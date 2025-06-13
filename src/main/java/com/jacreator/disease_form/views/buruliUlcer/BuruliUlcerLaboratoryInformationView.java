package com.jacreator.disease_form.views.buruliUlcer;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class BuruliUlcerLaboratoryInformationView extends VerticalLayout {

  public BuruliUlcerLaboratoryInformationView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Complete Address
    TextField address = new TextField("Complete Address");
    address.setPlaceholder("Enter Address");
    address.setRequired(true);

    // Add field to the form
    form.add(address);

    return form;
  }
}

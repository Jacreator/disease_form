package com.jacreator.disease_form.views.covid19;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class Covid19ContactTracingView extends VerticalLayout {
private TextField clientAddress;
    private TextField contactName;
    private TextField contactNumber;
    private TextField contactType;
    private RadioButtonGroup<String> contactCategory;
    private DatePicker dateContact;

    public Covid19ContactTracingView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();
        form.setWidthFull();
        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("900px", 2)
        );

        clientAddress = new TextField("Complete Address");
        clientAddress.setPlaceholder("Enter Address");

        contactName = new TextField("Contact Name");
        contactName.setPlaceholder("text text");

        contactNumber = new TextField("Contact Number");
        contactNumber.setPlaceholder("text text");

        contactType = new TextField("Type of Contact");
        contactType.setPlaceholder("text text");

        contactCategory = new RadioButtonGroup<>("Contact Categorization");
        contactCategory.setItems("high", "medium", "low");
        contactCategory.setRequired(true);
        contactCategory.setRequiredIndicatorVisible(true);

        dateContact = new DatePicker("Date of contact with a confirmed case");
        dateContact.setMax(LocalDate.now());

        form.add(
                clientAddress,
                contactName,
                contactNumber,
                contactType,
                contactCategory,
                dateContact
        );

        return form;
    }
}

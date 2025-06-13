package com.jacreator.disease_form.views.lassa_fever;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class LassaFeverContactTracingView extends VerticalLayout {
private final Map<String, List<String>> lgaData = new HashMap<>();
    private ComboBox<String> contactLgaOfResidence;
    private ComboBox<String> contactWardOfResidence;

    public LassaFeverContactTracingView() {
        setWidthFull();

        // State and LGA data
        lgaData.put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
        lgaData.put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));

        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Contact First Name
        TextField contactFirstName = new TextField("Contact First Name");
        contactFirstName.setPlaceholder("Enter First Name");
        contactFirstName.setRequired(true);

        // Contact Middle Name
        TextField contactMiddleName = new TextField("Contact Middle Name");
        contactMiddleName.setPlaceholder("Enter Middle Name");
        contactMiddleName.setRequired(true);

        // Contact Last Name
        TextField contactLastName = new TextField("Contact Last Name");
        contactLastName.setPlaceholder("Enter Last Name");
        contactLastName.setRequired(true);

        // Date of Birth
        DatePicker dateOfBirth = new DatePicker("Date of Birth");
        dateOfBirth.setMax(LocalDate.now());
        dateOfBirth.setRequired(true);

        // Age (Years and Months)
        TextField ageYears = new TextField("Age (Years)");
        ageYears.setPlaceholder("Estimated Years");
        ageYears.setRequired(true);
        ageYears.setTooltipText("Estimated Years");

        TextField ageMonths = new TextField("Age (Months)");
        ageMonths.setPlaceholder("Estimated Months");
        ageMonths.setTooltipText("Estimated Months");
        ageMonths.setEnabled(false);

        // Phone Number
        TextField phone = new TextField("Phone Number");
        phone.setRequired(true);

        // Contact State of Residence
        ComboBox<String> contactStateOfResidence = new ComboBox<>("Contact State of Residence");
        contactStateOfResidence.setItems("FCT", "Enugu");
        contactStateOfResidence.setPlaceholder("Select State");
        contactStateOfResidence.setRequired(true);

        // Contact LGA of Residence
        contactLgaOfResidence = new ComboBox<>("Contact LGA of Residence");
        contactLgaOfResidence.setPlaceholder("Select LGA");
        contactLgaOfResidence.setRequired(true);

        // Contact Ward of Residence
        contactWardOfResidence = new ComboBox<>("Contact Ward of Residence");
        contactWardOfResidence.setPlaceholder("Select Ward");
        contactWardOfResidence.setRequired(true);

        // Dynamic LGA and Ward population
        contactStateOfResidence.addValueChangeListener(event -> {
            String state = event.getValue();
            List<String> lgas = lgaData.getOrDefault(state, Collections.emptyList());
            contactLgaOfResidence.setItems(lgas);
            contactWardOfResidence.setItems(lgas); // Assuming wards are same as LGAs for this example
        });

        // Contact Residential Address
        TextField contactResidentialAddress = new TextField("Contact Residential Address");
        contactResidentialAddress.setPlaceholder("Enter Address");

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2),
            new FormLayout.ResponsiveStep("1200px", 3)
        );

        // Add all fields to the form
        form.add(
            contactFirstName,
            contactMiddleName,
            contactLastName,
            dateOfBirth,
            ageYears,
            ageMonths,
            phone,
            contactStateOfResidence,
            contactLgaOfResidence,
            contactWardOfResidence,
            contactResidentialAddress
        );

        return form;
    }
}

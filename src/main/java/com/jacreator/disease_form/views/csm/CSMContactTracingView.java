package com.jacreator.disease_form.views.csm;

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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class CSMContactTracingView extends VerticalLayout {
private TextField contactFirstName;
    private TextField contactLastName;
    private DatePicker contactDateOfBirth;
    private TextField contactAgeYears;
    private TextField contactAgeMonths;
    private RadioButtonGroup<String> contactSex;
    private ComboBox<String> contactStateOfResidence;
    private ComboBox<String> contactLgaOfResidence;
    private ComboBox<String> contactWardOfResidence;
    private TextField contactResidentialAddress;
    private ComboBox<String> relationshipWithCase;

    private static final List<String> relationshipWithCaseData = Arrays.asList(
            "Parent", "Sibling", "Child", "Neighbour", "Work/School Colleague",
            "Healthcare giver", "Patient", "Others"
    );
    private static final List<String> stateData = Arrays.asList("FCT", "Enugu");
    private static final Map<String, List<String>> lgaData = new HashMap<>() {{
        put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
        put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));
    }};

    public CSMContactTracingView() {
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
                new FormLayout.ResponsiveStep("800px", 2),
                new FormLayout.ResponsiveStep("1200px", 3)
        );

        contactFirstName = new TextField("Contact first name");
        contactFirstName.setPlaceholder("Enter First Name");
        contactFirstName.setRequired(true);
        contactFirstName.setRequiredIndicatorVisible(true);

        contactLastName = new TextField("Contact last name");
        contactLastName.setPlaceholder("Enter Last Name");
        contactLastName.setRequired(true);
        contactLastName.setRequiredIndicatorVisible(true);

        contactDateOfBirth = new DatePicker("Date of birth");
        contactDateOfBirth.setRequired(true);
        contactDateOfBirth.setRequiredIndicatorVisible(true);
        contactDateOfBirth.setMax(LocalDate.now());

        contactAgeYears = new TextField("Age (years)");
        contactAgeYears.setPlaceholder("Estimated Years");
        contactAgeYears.setRequired(true);
        contactAgeYears.setRequiredIndicatorVisible(true);
        contactAgeYears.setPattern("\\d*");
        // contactAgeYears.setPreventInvalidInput(true); // Method not available in Vaadin TextField

        contactAgeMonths = new TextField("Age (months)");
        contactAgeMonths.setPlaceholder("Estimated Months");
        contactAgeMonths.setPattern("\\d*");
        contactAgeMonths.setEnabled(false); // as in your code

        HorizontalLayout ageLayout = new HorizontalLayout(contactAgeYears, contactAgeMonths);
        ageLayout.setDefaultVerticalComponentAlignment(Alignment.END);

        contactSex = new RadioButtonGroup<>("Contact sex");
        contactSex.setItems("male", "female");
        contactSex.setRequired(true);
        contactSex.setRequiredIndicatorVisible(true);

        contactStateOfResidence = new ComboBox<>("Contact state of residence");
        contactStateOfResidence.setItems(stateData);
        contactStateOfResidence.setPlaceholder("Select State");
        contactStateOfResidence.setRequired(true);
        contactStateOfResidence.setRequiredIndicatorVisible(true);

        contactLgaOfResidence = new ComboBox<>("Contact LGA of residence");
        contactLgaOfResidence.setPlaceholder("Select LGA");
        contactLgaOfResidence.setRequired(true);
        contactLgaOfResidence.setRequiredIndicatorVisible(true);

        contactWardOfResidence = new ComboBox<>("Contact ward of residence");
        contactWardOfResidence.setPlaceholder("Select Ward");
        contactWardOfResidence.setRequired(true);
        contactWardOfResidence.setRequiredIndicatorVisible(true);

        contactStateOfResidence.addValueChangeListener(e -> {
            String selectedState = e.getValue();
            List<String> lgas = lgaData.getOrDefault(selectedState, Collections.emptyList());
            contactLgaOfResidence.setItems(lgas);
            contactWardOfResidence.setItems(lgas);
            contactLgaOfResidence.clear();
            contactWardOfResidence.clear();
        });

        contactResidentialAddress = new TextField("Contact residential address");
        contactResidentialAddress.setPlaceholder("Enter Contact Address");
        contactResidentialAddress.setRequired(true);
        contactResidentialAddress.setRequiredIndicatorVisible(true);

        relationshipWithCase = new ComboBox<>("Relationship with case");
        relationshipWithCase.setItems(relationshipWithCaseData);
        relationshipWithCase.setPlaceholder("Select Relationship");
        relationshipWithCase.setRequired(true);
        relationshipWithCase.setRequiredIndicatorVisible(true);

        form.add(
                contactFirstName,
                contactLastName,
                contactDateOfBirth,
                ageLayout,
                contactSex,
                contactStateOfResidence,
                contactLgaOfResidence,
                contactWardOfResidence,
                contactResidentialAddress,
                relationshipWithCase
        );

        return form;
    }
}

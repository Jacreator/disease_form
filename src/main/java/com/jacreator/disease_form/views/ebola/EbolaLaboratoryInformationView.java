package com.jacreator.disease_form.views.ebola;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class EbolaLaboratoryInformationView extends VerticalLayout {
// Static data
    private static final List<String> NAME_OF_TESTING_LABORATORY = Arrays.asList(
            "National Reference Laboratory (NRL)",
            "Central Public Health Laboratory (CPHL)"
    );

    // Form fields
    private RadioButtonGroup<String> specimenCollected;
    private TextField whySpecimenNotCollected;
    private DatePicker dateSpecimenCollected;
    private CheckboxGroup<String> specimenType;
    private ComboBox<String> nameOfTestingLaboratory;
    private DatePicker dateSpecimenSent;
    private RadioButtonGroup<String> specimenReceived;
    private CheckboxGroup<String> typeOfSpecimenReceived;
    private DatePicker dateSpecimenReceived;
    private TextField laboratoryId;
    private CheckboxGroup<String> typeOfTestConducted;
    private RadioButtonGroup<String> specimenConditionPCR;
    private RadioButtonGroup<String> pcrResult;
    private DatePicker dateResultAvailablePCR;
    private DatePicker dateResultSentPCR;
    private RadioButtonGroup<String> specimenConditionSerology;
    private RadioButtonGroup<String> serologyResult;
    private DatePicker dateResultAvailableSerology;
    private DatePicker dateResultSentSerology;

    // State for dynamic fields
    private Set<String> selectedTypeOfSpecimenReceived = new HashSet<>();
    private Set<String> selectedTypeOfTestConducted = new HashSet<>();

    public EbolaLaboratoryInformationView() {
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
                new FormLayout.ResponsiveStep("600px", 2)
        );

        // Specimen Collected?
        specimenCollected = new RadioButtonGroup<>("Specimen Collected?");
        specimenCollected.setItems("yes", "no");
        specimenCollected.setRequired(true);
        specimenCollected.setRequiredIndicatorVisible(true);

        whySpecimenNotCollected = new TextField("Why was specimen not collected?");
        whySpecimenNotCollected.setPlaceholder("Enter Reason");
        whySpecimenNotCollected.setVisible(false);

        dateSpecimenCollected = new DatePicker("Date of Specimen Collection");
        dateSpecimenCollected.setMax(LocalDate.now());
        dateSpecimenCollected.setVisible(false);

        specimenType = new CheckboxGroup<>("Type of Specimen collected?");
        specimenType.setItems("Blood", "Crust", "Swab");
        specimenType.setVisible(false);

        nameOfTestingLaboratory = new ComboBox<>("Name of Testing Laboratory");
        nameOfTestingLaboratory.setItems(NAME_OF_TESTING_LABORATORY);
        nameOfTestingLaboratory.setVisible(false);

        dateSpecimenSent = new DatePicker("Date of Specimen Sent");
        dateSpecimenSent.setMax(LocalDate.now());
        dateSpecimenSent.setVisible(false);

        specimenCollected.addValueChangeListener(e -> {
            String value = e.getValue();
            boolean collected = "yes".equals(value);
            whySpecimenNotCollected.setVisible("no".equals(value));
            dateSpecimenCollected.setVisible(collected);
            specimenType.setVisible(collected);
            nameOfTestingLaboratory.setVisible(collected);
            dateSpecimenSent.setVisible(collected);
        });

        // Specimen Received?
        specimenReceived = new RadioButtonGroup<>("Specimen Received?");
        specimenReceived.setItems("yes", "no");
        specimenReceived.setRequired(true);
        specimenReceived.setRequiredIndicatorVisible(true);

        typeOfSpecimenReceived = new CheckboxGroup<>("Type of specimen Received?");
        typeOfSpecimenReceived.setItems("Blood", "Crust", "Swab");
        typeOfSpecimenReceived.setVisible(false);

        dateSpecimenReceived = new DatePicker("Date of Specimen Received");
        dateSpecimenReceived.setMax(LocalDate.now());
        dateSpecimenReceived.setVisible(false);

        laboratoryId = new TextField("Laboratory ID");
        laboratoryId.setPlaceholder("Enter specimen Id");
        laboratoryId.setVisible(false);

        typeOfTestConducted = new CheckboxGroup<>("Type of test conducted?");
        typeOfTestConducted.setVisible(false);

        specimenReceived.addValueChangeListener(e -> {
            boolean received = "yes".equals(e.getValue());
            typeOfSpecimenReceived.setVisible(received);
            dateSpecimenReceived.setVisible(received);
            laboratoryId.setVisible(received);
            typeOfTestConducted.setVisible(false);
            specimenConditionPCR.setVisible(false);
            pcrResult.setVisible(false);
            dateResultAvailablePCR.setVisible(false);
            dateResultSentPCR.setVisible(false);
            specimenConditionSerology.setVisible(false);
            serologyResult.setVisible(false);
            dateResultAvailableSerology.setVisible(false);
            dateResultSentSerology.setVisible(false);
        });

        // Dynamic test options based on specimen received
        typeOfSpecimenReceived.addValueChangeListener(e -> {
            selectedTypeOfSpecimenReceived = e.getValue();
            List<String> testOptions = getTestOptions(selectedTypeOfSpecimenReceived);
            typeOfTestConducted.setItems(testOptions);
            typeOfTestConducted.setVisible(!testOptions.isEmpty());
        });

        // PCR/Serology result sections
        specimenConditionPCR = new RadioButtonGroup<>("Specimen Condition?");
        specimenConditionPCR.setItems("Adequate", "Not adequate");
        specimenConditionPCR.setVisible(false);

        pcrResult = new RadioButtonGroup<>("PCR Result");
        pcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        pcrResult.setVisible(false);

        dateResultAvailablePCR = new DatePicker("Date of Result Available");
        dateResultAvailablePCR.setMax(LocalDate.now());
        dateResultAvailablePCR.setVisible(false);

        dateResultSentPCR = new DatePicker("Date Result sent");
        dateResultSentPCR.setMax(LocalDate.now());
        dateResultSentPCR.setVisible(false);

        specimenConditionSerology = new RadioButtonGroup<>("Specimen Condition?");
        specimenConditionSerology.setItems("Adequate", "Not adequate");
        specimenConditionSerology.setVisible(false);

        serologyResult = new RadioButtonGroup<>("Serology Result");
        serologyResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        serologyResult.setVisible(false);

        dateResultAvailableSerology = new DatePicker("Date of Result Available");
        dateResultAvailableSerology.setMax(LocalDate.now());
        dateResultAvailableSerology.setVisible(false);

        dateResultSentSerology = new DatePicker("Date Result sent");
        dateResultSentSerology.setMax(LocalDate.now());
        dateResultSentSerology.setVisible(false);

        typeOfTestConducted.addValueChangeListener(e -> {
            selectedTypeOfTestConducted = e.getValue();
            boolean showPCR = selectedTypeOfTestConducted.contains("PCR");
            boolean showSerology = selectedTypeOfTestConducted.contains("Serology");

            specimenConditionPCR.setVisible(showPCR);
            pcrResult.setVisible(showPCR);
            dateResultAvailablePCR.setVisible(showPCR);
            dateResultSentPCR.setVisible(showPCR);

            specimenConditionSerology.setVisible(showSerology);
            serologyResult.setVisible(showSerology);
            dateResultAvailableSerology.setVisible(showSerology);
            dateResultSentSerology.setVisible(showSerology);
        });

        // Add all components to the form
        form.add(
                specimenCollected, whySpecimenNotCollected,
                dateSpecimenCollected, specimenType, nameOfTestingLaboratory, dateSpecimenSent,
                specimenReceived, typeOfSpecimenReceived, dateSpecimenReceived, laboratoryId,
                typeOfTestConducted,
                specimenConditionPCR, pcrResult, dateResultAvailablePCR, dateResultSentPCR,
                specimenConditionSerology, serologyResult, dateResultAvailableSerology, dateResultSentSerology
        );

        return form;
    }

    // Logic for test options based on specimen received
    private List<String> getTestOptions(Set<String> specimens) {
        if (specimens == null || specimens.isEmpty()) return Collections.emptyList();
        if (specimens.size() == 3) return Arrays.asList("Serology", "PCR");
        if (specimens.size() == 2) {
            if (specimens.contains("blood") && (specimens.contains("swab") || specimens.contains("crust")))
                return Arrays.asList("Serology", "PCR");
            if (specimens.contains("swab") && specimens.contains("crust"))
                return Collections.singletonList("PCR");
        }
        if (specimens.size() == 1) {
            if (specimens.contains("blood")) return Collections.singletonList("Serology");
            if (specimens.contains("crust") || specimens.contains("swab")) return Collections.singletonList("PCR");
        }
        return Collections.emptyList();
    }
}

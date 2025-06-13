package com.jacreator.disease_form.views.mpox;

import java.time.LocalDate;
import java.util.Arrays;
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

public class MpoxLaboratoryInformationView extends VerticalLayout {
private String specimenCollectedValue = null;
    private List<String> specimenTypeValue = null;
    private String bloodSampleReceivedValue = null;
    private List<String> bloodTestConductedValue = null;
    private String resultBloodPcrValue = null;
    private String resultBloodSerologyValue = null;
    private String crustSampleReceivedValue = null;
    private List<String> testConductedCrustValue = null;
    private String resultCrustPcrValue = null;
    private String resultCrustSerologyValue = null;
    private String swabSampleReceivedValue = null;
    private List<String> testConductedSwabValue = null;
    private String resultSwabPcrValue = null;
    private String resultSwabSerologyValue = null;

    // Form fields that need to be shown/hidden
    private DatePicker dateSpecimenCollected;
    private CheckboxGroup<String> specimenType;
    private DatePicker dateSpecimenSent;
    private ComboBox<String> nameOfTestingLaboratory;

    // Blood
    private RadioButtonGroup<String> bloodSampleReceived;
    private DatePicker dateSpecimenReceivedBlood;
    private TextField laboratoryIdBlood;
    private RadioButtonGroup<String> specimenConditionBlood;
    private CheckboxGroup<String> bloodTestConducted;
    private RadioButtonGroup<String> resultBloodPcr;
    private DatePicker dateResultReleasedBloodPcr;
    private RadioButtonGroup<String> resultBloodSerology;
    private DatePicker dateResultReleasedBloodSerology;

    // Crust
    private RadioButtonGroup<String> crustSampleReceived;
    private DatePicker dateSpecimenReceivedCrust;
    private TextField laboratoryIdCrust;
    private RadioButtonGroup<String> specimenConditionCrust;
    private CheckboxGroup<String> testConductedCrust;
    private RadioButtonGroup<String> resultCrustPcr;
    private DatePicker dateResultReleasedCrustPcr;
    private RadioButtonGroup<String> resultCrustSerology;
    private DatePicker dateResultReleasedCrustSerology;

    // Swab
    private RadioButtonGroup<String> swabSampleReceived;
    private DatePicker dateSpecimenReceivedSwab;
    private TextField laboratoryIdSwab;
    private RadioButtonGroup<String> specimenConditionSwab;
    private CheckboxGroup<String> testConductedSwab;
    private RadioButtonGroup<String> resultSwabPcr;
    private DatePicker dateResultReleasedSwabPcr;
    private RadioButtonGroup<String> resultSwabSerology;
    private DatePicker dateResultReleasedSwabSerology;

    public MpoxLaboratoryInformationView() {
        setWidthFull();
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // Laboratory options
        List<String> laboratoryOptions = Arrays.asList(
            "ACEGID -African Centre of Excellence for Genomics of Infectious Diseases, Ogun",
            "AE-FUTHA -Alex Ekwueme Federal University Teaching Hospital Virology Laboratory",
            "BUK -Bayero University Kano Centre for Infectious Disease and Research, Kano",
            "FMC JALINGO -Federal Medical Centre, Jalingo, Taraba",
            "FMC OWO -Federal Medical Centre Owo, Ondo",
            "ISTH -Irrua Specialist Teaching Hospital, Edo",
            "LUTH -Lagos University Teaching Hospital Virology Laboratory, Lagos",
            "MOGID -Molecular Genetics and Infectious Diseases Research Laboratory, Bauchi",
            "NRL -National Reference Laboratory Gaduwa, FCT"
        );

        // Specimen collected
        RadioButtonGroup<String> specimenCollected = new RadioButtonGroup<>();
        specimenCollected.setLabel("Specimen collected");
        specimenCollected.setItems("Yes", "No");
        specimenCollected.setRequired(true);

        // Date specimen collected
        dateSpecimenCollected = new DatePicker("Date specimen collected");
        dateSpecimenCollected.setMax(LocalDate.now());
        dateSpecimenCollected.setRequired(true);
        dateSpecimenCollected.setVisible(false);

        // Type of specimen collected
        specimenType = new CheckboxGroup<>();
        specimenType.setLabel("Type of specimen collected?");
        specimenType.setItems("Blood", "Crust", "Swab");
        specimenType.setRequired(true);
        specimenType.setVisible(false);

        // Date specimen sent
        dateSpecimenSent = new DatePicker("Date specimen sent");
        dateSpecimenSent.setMax(LocalDate.now());
        dateSpecimenSent.setRequired(true);
        dateSpecimenSent.setVisible(false);

        // Name of testing laboratory
        nameOfTestingLaboratory = new ComboBox<>("Name of testing laboratory");
        nameOfTestingLaboratory.setItems(laboratoryOptions);
        nameOfTestingLaboratory.setPlaceholder("Select Laboratory Name");
        nameOfTestingLaboratory.setRequired(true);
        nameOfTestingLaboratory.setVisible(false);

        // Blood section
        bloodSampleReceived = new RadioButtonGroup<>();
        bloodSampleReceived.setLabel("Blood specimen received");
        bloodSampleReceived.setItems("Yes", "No");
        bloodSampleReceived.setRequired(true);
        bloodSampleReceived.setVisible(false);

        dateSpecimenReceivedBlood = new DatePicker("Date specimen received");
        dateSpecimenReceivedBlood.setMax(LocalDate.now());
        dateSpecimenReceivedBlood.setRequired(true);
        dateSpecimenReceivedBlood.setVisible(false);

        laboratoryIdBlood = new TextField("Laboratory ID");
        laboratoryIdBlood.setPlaceholder("Enter Lab ID");
        laboratoryIdBlood.setVisible(false);

        specimenConditionBlood = new RadioButtonGroup<>();
        specimenConditionBlood.setLabel("Specimen condition");
        specimenConditionBlood.setItems("Adequate", "Not Adequate");
        specimenConditionBlood.setRequired(true);
        specimenConditionBlood.setVisible(false);

        bloodTestConducted = new CheckboxGroup<>();
        bloodTestConducted.setLabel("Test conducted");
        bloodTestConducted.setItems("PCR", "Serology");
        bloodTestConducted.setRequired(true);
        bloodTestConducted.setVisible(false);

        resultBloodPcr = new RadioButtonGroup<>();
        resultBloodPcr.setLabel("PCR result");
        resultBloodPcr.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        resultBloodPcr.setRequired(true);
        resultBloodPcr.setVisible(false);

        dateResultReleasedBloodPcr = new DatePicker("Date result released");
        dateResultReleasedBloodPcr.setMax(LocalDate.now());
        dateResultReleasedBloodPcr.setRequired(true);
        dateResultReleasedBloodPcr.setVisible(false);

        resultBloodSerology = new RadioButtonGroup<>();
        resultBloodSerology.setLabel("Serology result");
        resultBloodSerology.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        resultBloodSerology.setRequired(true);
        resultBloodSerology.setVisible(false);

        dateResultReleasedBloodSerology = new DatePicker("Date result released");
        dateResultReleasedBloodSerology.setMax(LocalDate.now());
        dateResultReleasedBloodSerology.setRequired(true);
        dateResultReleasedBloodSerology.setVisible(false);

        // Crust section
        crustSampleReceived = new RadioButtonGroup<>();
        crustSampleReceived.setLabel("Crust specimen received");
        crustSampleReceived.setItems("Yes", "No");
        crustSampleReceived.setRequired(true);
        crustSampleReceived.setVisible(false);

        dateSpecimenReceivedCrust = new DatePicker("Date specimen received");
        dateSpecimenReceivedCrust.setMax(LocalDate.now());
        dateSpecimenReceivedCrust.setRequired(true);
        dateSpecimenReceivedCrust.setVisible(false);

        laboratoryIdCrust = new TextField("Laboratory ID");
        laboratoryIdCrust.setPlaceholder("Enter Lab ID");
        laboratoryIdCrust.setVisible(false);

        specimenConditionCrust = new RadioButtonGroup<>();
        specimenConditionCrust.setLabel("Specimen condition");
        specimenConditionCrust.setItems("Adequate", "Not Adequate");
        specimenConditionCrust.setRequired(true);
        specimenConditionCrust.setVisible(false);

        testConductedCrust = new CheckboxGroup<>();
        testConductedCrust.setLabel("Test conducted");
        testConductedCrust.setItems("PCR", "Serology");
        testConductedCrust.setRequired(true);
        testConductedCrust.setVisible(false);

        resultCrustPcr = new RadioButtonGroup<>();
        resultCrustPcr.setLabel("PCR result");
        resultCrustPcr.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        resultCrustPcr.setRequired(true);
        resultCrustPcr.setVisible(false);

        dateResultReleasedCrustPcr = new DatePicker("Date result released");
        dateResultReleasedCrustPcr.setMax(LocalDate.now());
        dateResultReleasedCrustPcr.setRequired(true);
        dateResultReleasedCrustPcr.setVisible(false);

        resultCrustSerology = new RadioButtonGroup<>();
        resultCrustSerology.setLabel("Serology result");
        resultCrustSerology.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        resultCrustSerology.setRequired(true);
        resultCrustSerology.setVisible(false);

        dateResultReleasedCrustSerology = new DatePicker("Date result released");
        dateResultReleasedCrustSerology.setMax(LocalDate.now());
        dateResultReleasedCrustSerology.setRequired(true);
        dateResultReleasedCrustSerology.setVisible(false);

        // Swab section
        swabSampleReceived = new RadioButtonGroup<>();
        swabSampleReceived.setLabel("Swab specimen received");
        swabSampleReceived.setItems("Yes", "No");
        swabSampleReceived.setRequired(true);
        swabSampleReceived.setVisible(false);

        dateSpecimenReceivedSwab = new DatePicker("Date specimen received");
        dateSpecimenReceivedSwab.setMax(LocalDate.now());
        dateSpecimenReceivedSwab.setRequired(true);
        dateSpecimenReceivedSwab.setVisible(false);

        laboratoryIdSwab = new TextField("Laboratory ID");
        laboratoryIdSwab.setPlaceholder("Enter Lab ID");
        laboratoryIdSwab.setVisible(false);

        specimenConditionSwab = new RadioButtonGroup<>();
        specimenConditionSwab.setLabel("Specimen condition");
        specimenConditionSwab.setItems("Adequate", "Not Adequate");
        specimenConditionSwab.setRequired(true);
        specimenConditionSwab.setVisible(false);

        testConductedSwab = new CheckboxGroup<>();
        testConductedSwab.setLabel("Test conducted");
        testConductedSwab.setItems("PCR", "Serology");
        testConductedSwab.setRequired(true);
        testConductedSwab.setVisible(false);

        resultSwabPcr = new RadioButtonGroup<>();
        resultSwabPcr.setLabel("PCR result");
        resultSwabPcr.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        resultSwabPcr.setRequired(true);
        resultSwabPcr.setVisible(false);

        dateResultReleasedSwabPcr = new DatePicker("Date result released");
        dateResultReleasedSwabPcr.setMax(LocalDate.now());
        dateResultReleasedSwabPcr.setRequired(true);
        dateResultReleasedSwabPcr.setVisible(false);

        resultSwabSerology = new RadioButtonGroup<>();
        resultSwabSerology.setLabel("Serology result");
        resultSwabSerology.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
        resultSwabSerology.setRequired(true);
        resultSwabSerology.setVisible(false);

        dateResultReleasedSwabSerology = new DatePicker("Date result released");
        dateResultReleasedSwabSerology.setMax(LocalDate.now());
        dateResultReleasedSwabSerology.setRequired(true);
        dateResultReleasedSwabSerology.setVisible(false);

        // Conditional logic for specimenCollected
        specimenCollected.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateSpecimenCollected.setVisible(show);
            specimenType.setVisible(show);
            dateSpecimenSent.setVisible(show);
            nameOfTestingLaboratory.setVisible(show);

            // Hide all specimen result sections if not "Yes"
            bloodSampleReceived.setVisible(false);
            crustSampleReceived.setVisible(false);
            swabSampleReceived.setVisible(false);
        });

        // Conditional logic for specimenType
        specimenType.addValueChangeListener(event -> {
            Set<String> selected = event.getValue();
            boolean hasBlood = selected.contains("Blood");
            boolean hasCrust = selected.contains("Crust");
            boolean hasSwab = selected.contains("Swab");

            // Show/hide blood section
            bloodSampleReceived.setVisible(hasBlood);
            // Show/hide crust section
            crustSampleReceived.setVisible(hasCrust);
            // Show/hide swab section
            swabSampleReceived.setVisible(hasSwab);

            // Show dateSpecimenSent if any specimen type is selected
            dateSpecimenSent.setVisible(selected.size() >= 1);
        });

        // Blood section logic
        bloodSampleReceived.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateSpecimenReceivedBlood.setVisible(show);
            laboratoryIdBlood.setVisible(show);
            specimenConditionBlood.setVisible(show);
            bloodTestConducted.setVisible(show);
        });
        bloodTestConducted.addValueChangeListener(event -> {
            Set<String> selected = event.getValue();
            boolean hasPcr = selected.contains("PCR");
            boolean hasSerology = selected.contains("Serology");
            resultBloodPcr.setVisible(hasPcr);
            resultBloodSerology.setVisible(hasSerology);
        });
        resultBloodPcr.addValueChangeListener(event -> {
            boolean show = Arrays.asList("Positive", "Negative", "Indeterminate").contains(event.getValue());
            dateResultReleasedBloodPcr.setVisible(show);
        });
        resultBloodSerology.addValueChangeListener(event -> {
            boolean show = Arrays.asList("Positive", "Negative", "Indeterminate").contains(event.getValue());
            dateResultReleasedBloodSerology.setVisible(show);
        });

        // Crust section logic
        crustSampleReceived.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateSpecimenReceivedCrust.setVisible(show);
            laboratoryIdCrust.setVisible(show);
            specimenConditionCrust.setVisible(show);
            testConductedCrust.setVisible(show);
        });
        testConductedCrust.addValueChangeListener(event -> {
            Set<String> selected = event.getValue();
            boolean hasPcr = selected.contains("PCR");
            boolean hasSerology = selected.contains("Serology");
            resultCrustPcr.setVisible(hasPcr);
            resultCrustSerology.setVisible(hasSerology);
        });
        resultCrustPcr.addValueChangeListener(event -> {
            boolean show = Arrays.asList("Positive", "Negative", "Indeterminate").contains(event.getValue());
            dateResultReleasedCrustPcr.setVisible(show);
        });
        resultCrustSerology.addValueChangeListener(event -> {
            boolean show = Arrays.asList("Positive", "Negative", "Indeterminate").contains(event.getValue());
            dateResultReleasedCrustSerology.setVisible(show);
        });

        // Swab section logic
        swabSampleReceived.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateSpecimenReceivedSwab.setVisible(show);
            laboratoryIdSwab.setVisible(show);
            specimenConditionSwab.setVisible(show);
            testConductedSwab.setVisible(show);
        });
        testConductedSwab.addValueChangeListener(event -> {
            Set<String> selected = event.getValue();
            boolean hasPcr = selected.contains("PCR");
            boolean hasSerology = selected.contains("Serology");
            resultSwabPcr.setVisible(hasPcr);
            resultSwabSerology.setVisible(hasSerology);
        });
        resultSwabPcr.addValueChangeListener(event -> {
            boolean show = Arrays.asList("Positive", "Negative", "Indeterminate").contains(event.getValue());
            dateResultReleasedSwabPcr.setVisible(show);
        });
        resultSwabSerology.addValueChangeListener(event -> {
            boolean show = Arrays.asList("Positive", "Negative", "Indeterminate").contains(event.getValue());
            dateResultReleasedSwabSerology.setVisible(show);
        });

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("800px", 2)
        );

        // Add all fields to the form
        form.add(
            specimenCollected,
            dateSpecimenCollected,
            specimenType,
            dateSpecimenSent,
            nameOfTestingLaboratory,

            // Blood
            bloodSampleReceived,
            dateSpecimenReceivedBlood,
            laboratoryIdBlood,
            specimenConditionBlood,
            bloodTestConducted,
            resultBloodPcr,
            dateResultReleasedBloodPcr,
            resultBloodSerology,
            dateResultReleasedBloodSerology,

            // Crust
            crustSampleReceived,
            dateSpecimenReceivedCrust,
            laboratoryIdCrust,
            specimenConditionCrust,
            testConductedCrust,
            resultCrustPcr,
            dateResultReleasedCrustPcr,
            resultCrustSerology,
            dateResultReleasedCrustSerology,

            // Swab
            swabSampleReceived,
            dateSpecimenReceivedSwab,
            laboratoryIdSwab,
            specimenConditionSwab,
            testConductedSwab,
            resultSwabPcr,
            dateResultReleasedSwabPcr,
            resultSwabSerology,
            dateResultReleasedSwabSerology
        );

        return form;
    }
}

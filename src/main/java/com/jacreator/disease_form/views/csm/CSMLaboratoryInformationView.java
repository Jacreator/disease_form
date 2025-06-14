package com.jacreator.disease_form.views.csm;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class CSMLaboratoryInformationView extends VerticalLayout {
private RadioButtonGroup<String> specimenCollected;
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
    private RadioButtonGroup<String> resultBloodRdt;
    private DatePicker dateResultReleasedBloodRdt;
    private RadioButtonGroup<String> resultBloodCulture;
    private DatePicker dateResultReleasedBloodCulture;

    // CSF
    private RadioButtonGroup<String> csfSampleReceived;
    private DatePicker dateSpecimenReceivedCsf;
    private TextField laboratoryIdCsf;
    private RadioButtonGroup<String> specimenConditionCsf;
    private CheckboxGroup<String> testConductedCsf;
    private RadioButtonGroup<String> resultCsfPcr;
    private DatePicker dateResultReleasedCsfPcr;
    private RadioButtonGroup<String> resultCsfCulture;
    private DatePicker dateResultReleasedCsfCulture;

    private static final String[] testingLaboratoryData = {
            "ACEGID -African Centre of Excellence for Genomics of Infectious Diseases, Ogun",
            "AE-FUTHA -Alex Ekwueme Federal University Teaching Hospital Virology Laboratory",
            "BUK -Bayero University Kano Centre for Infectious Disease and Research, Kano",
            "FMC JALINGO -Federal Medical Centre, Jalingo, Taraba",
            "FMC OWO -Federal Medical Centre Owo, Ondo",
            "ISTH -Irrua Specialist Teaching Hospital, Edo",
            "LUTH -Lagos University Teaching Hospital Virology Laboratory, Lagos",
            "MOGID -Molecular Genetics and Infectious Diseases Research Laboratory, Bauchi",
            "NRL -National Reference Laboratory Gaduwa, FCT"
    };

    public CSMLaboratoryInformationView() {
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
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));

        specimenCollected = new RadioButtonGroup<>("Specimen collected");
        specimenCollected.setItems("yes", "no");
        specimenCollected.setRequired(true);
        specimenCollected.setRequiredIndicatorVisible(true);

        dateSpecimenCollected = new DatePicker("Date specimen collected");
        dateSpecimenCollected.setMax(LocalDate.now());
        dateSpecimenCollected.setVisible(false);

        specimenType = new CheckboxGroup<>("Type of specimen collected?");
        specimenType.setItems("cerebrospinalFluid", "blood");
        specimenType.setVisible(false);

        dateSpecimenSent = new DatePicker("Date specimen sent");
        dateSpecimenSent.setMax(LocalDate.now());
        dateSpecimenSent.setVisible(false);

        nameOfTestingLaboratory = new ComboBox<>("Name of testing laboratory");
        nameOfTestingLaboratory.setItems(Arrays.asList(testingLaboratoryData));
        nameOfTestingLaboratory.setClearButtonVisible(true);
        nameOfTestingLaboratory.setVisible(false);

        // Blood
        bloodSampleReceived = new RadioButtonGroup<>("Blood specimen received");
        bloodSampleReceived.setItems("yes", "no");
        bloodSampleReceived.setVisible(false);

        dateSpecimenReceivedBlood = new DatePicker("Date specimen received (Blood)");
        dateSpecimenReceivedBlood.setMax(LocalDate.now());
        dateSpecimenReceivedBlood.setVisible(false);

        laboratoryIdBlood = new TextField("Laboratory ID (Blood)");
        laboratoryIdBlood.setVisible(false);

        specimenConditionBlood = new RadioButtonGroup<>("Specimen condition (Blood)");
        specimenConditionBlood.setItems("adequate", "not adequate");
        specimenConditionBlood.setVisible(false);

        bloodTestConducted = new CheckboxGroup<>("Test conducted (Blood)");
        bloodTestConducted.setItems("pcr", "rdt", "culture");
        bloodTestConducted.setVisible(false);

        resultBloodPcr = new RadioButtonGroup<>("PCR result (Blood)");
        resultBloodPcr.setItems("positive", "negative", "indeterminate", "pending", "not done");
        resultBloodPcr.setVisible(false);

        dateResultReleasedBloodPcr = new DatePicker("Date result released (Blood PCR)");
        dateResultReleasedBloodPcr.setMax(LocalDate.now());
        dateResultReleasedBloodPcr.setVisible(false);

        resultBloodRdt = new RadioButtonGroup<>("RDT result (Blood)");
        resultBloodRdt.setItems("positive", "negative", "indeterminate", "pending", "not done");
        resultBloodRdt.setVisible(false);

        dateResultReleasedBloodRdt = new DatePicker("Date result released (Blood RDT)");
        dateResultReleasedBloodRdt.setMax(LocalDate.now());
        dateResultReleasedBloodRdt.setVisible(false);

        resultBloodCulture = new RadioButtonGroup<>("Culture result (Blood)");
        resultBloodCulture.setItems("growth", "no growth");
        resultBloodCulture.setVisible(false);

        dateResultReleasedBloodCulture = new DatePicker("Date result released (Blood Culture)");
        dateResultReleasedBloodCulture.setMax(LocalDate.now());
        dateResultReleasedBloodCulture.setVisible(false);

        // CSF
        csfSampleReceived = new RadioButtonGroup<>("Cerebrospinal fluid specimen received");
        csfSampleReceived.setItems("yes", "no");
        csfSampleReceived.setVisible(false);

        dateSpecimenReceivedCsf = new DatePicker("Date specimen received (CSF)");
        dateSpecimenReceivedCsf.setMax(LocalDate.now());
        dateSpecimenReceivedCsf.setVisible(false);

        laboratoryIdCsf = new TextField("Laboratory ID (CSF)");
        laboratoryIdCsf.setVisible(false);

        specimenConditionCsf = new RadioButtonGroup<>("Specimen condition (CSF)");
        specimenConditionCsf.setItems("adequate", "not adequate");
        specimenConditionCsf.setVisible(false);

        testConductedCsf = new CheckboxGroup<>("Test conducted (CSF)");
        testConductedCsf.setItems("pcr", "culture");
        testConductedCsf.setVisible(false);

        resultCsfPcr = new RadioButtonGroup<>("PCR result (CSF)");
        resultCsfPcr.setItems("positive", "negative", "indeterminate", "pending", "not done");
        resultCsfPcr.setVisible(false);

        dateResultReleasedCsfPcr = new DatePicker("Date result released (CSF PCR)");
        dateResultReleasedCsfPcr.setMax(LocalDate.now());
        dateResultReleasedCsfPcr.setVisible(false);

        resultCsfCulture = new RadioButtonGroup<>("Culture result (CSF)");
        resultCsfCulture.setItems("growth", "no growth");
        resultCsfCulture.setVisible(false);

        dateResultReleasedCsfCulture = new DatePicker("Date result released (CSF Culture)");
        dateResultReleasedCsfCulture.setMax(LocalDate.now());
        dateResultReleasedCsfCulture.setVisible(false);

        // Dynamic logic
        specimenCollected.addValueChangeListener(e -> {
            boolean collected = "yes".equals(e.getValue());
            dateSpecimenCollected.setVisible(collected);
            specimenType.setVisible(collected);
            nameOfTestingLaboratory.setVisible(collected);
            if (!collected) {
                dateSpecimenCollected.clear();
                specimenType.clear();
                nameOfTestingLaboratory.clear();
            }
        });

        specimenType.addValueChangeListener(e -> {
            Set<String> types = e.getValue() != null ? e.getValue() : new LinkedHashSet<>();
            dateSpecimenSent.setVisible(!types.isEmpty());
            bloodSampleReceived.setVisible(types.contains("blood"));
            csfSampleReceived.setVisible(types.contains("cerebrospinalFluid"));
        });

        bloodSampleReceived.addValueChangeListener(e -> {
            boolean received = "yes".equals(e.getValue());
            dateSpecimenReceivedBlood.setVisible(received);
            laboratoryIdBlood.setVisible(received);
            specimenConditionBlood.setVisible(received);
            bloodTestConducted.setVisible(received);
            if (!received) {
                dateSpecimenReceivedBlood.clear();
                laboratoryIdBlood.clear();
                specimenConditionBlood.clear();
                bloodTestConducted.clear();
            }
        });

        bloodTestConducted.addValueChangeListener(e -> {
            Set<String> tests = e.getValue() != null ? e.getValue() : new LinkedHashSet<>();
            resultBloodPcr.setVisible(tests.contains("pcr"));
            dateResultReleasedBloodPcr.setVisible(tests.contains("pcr"));
            resultBloodRdt.setVisible(tests.contains("rdt"));
            dateResultReleasedBloodRdt.setVisible(tests.contains("rdt"));
            resultBloodCulture.setVisible(tests.contains("culture"));
        });

        resultBloodCulture.addValueChangeListener(e -> {
            boolean growth = "growth".equals(e.getValue());
            dateResultReleasedBloodCulture.setVisible(growth);
        });

        csfSampleReceived.addValueChangeListener(e -> {
            boolean received = "yes".equals(e.getValue());
            dateSpecimenReceivedCsf.setVisible(received);
            laboratoryIdCsf.setVisible(received);
            specimenConditionCsf.setVisible(received);
            testConductedCsf.setVisible(received);
            if (!received) {
                dateSpecimenReceivedCsf.clear();
                laboratoryIdCsf.clear();
                specimenConditionCsf.clear();
                testConductedCsf.clear();
            }
        });

        testConductedCsf.addValueChangeListener(e -> {
            Set<String> tests = e.getValue() != null ? e.getValue() : new LinkedHashSet<>();
            resultCsfPcr.setVisible(tests.contains("pcr"));
            dateResultReleasedCsfPcr.setVisible(tests.contains("pcr"));
            resultCsfCulture.setVisible(tests.contains("culture"));
        });

        resultCsfCulture.addValueChangeListener(e -> {
            boolean growth = "growth".equals(e.getValue());
            dateResultReleasedCsfCulture.setVisible(growth);
        });

        // Add all fields to the form
        form.add(
                specimenCollected,
                dateSpecimenCollected,
                specimenType,
                dateSpecimenSent,
                nameOfTestingLaboratory,
                new Hr(),
                bloodSampleReceived,
                dateSpecimenReceivedBlood,
                laboratoryIdBlood,
                specimenConditionBlood,
                bloodTestConducted,
                resultBloodPcr,
                dateResultReleasedBloodPcr,
                resultBloodRdt,
                dateResultReleasedBloodRdt,
                resultBloodCulture,
                dateResultReleasedBloodCulture,
                new Hr(),
                csfSampleReceived,
                dateSpecimenReceivedCsf,
                laboratoryIdCsf,
                specimenConditionCsf,
                testConductedCsf,
                resultCsfPcr,
                dateResultReleasedCsfPcr,
                resultCsfCulture,
                dateResultReleasedCsfCulture
        );

        return form;
    }
}

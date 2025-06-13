package com.jacreator.disease_form.views.covid19;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class Covid19LaboratoryInformationView extends VerticalLayout {
private static final List<String> testingLaboratoryData = Arrays.asList(
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

    // Fields
    private RadioButtonGroup<String> specimenCollected;
    private DatePicker dateSpecimenCollected;
    private CheckboxGroup<String> specimenType;
    private DatePicker dateSpecimenSent;
    private ComboBox<String> nameOfTestingLaboratory;

    // Nasal/Throat/NP
    private RadioButtonGroup<String> nSwabSpecimenReceived;
    private RadioButtonGroup<String> tSwabSpecimenReceived;
    private RadioButtonGroup<String> npSwabSpecimenReceived;
    private DatePicker dateSecimenReceivedNasalThroatNp;
    private TextField laboratoryIdNasalThroatNp;
    private RadioButtonGroup<String> specimenConditionNasalThroatNp;
    private CheckboxGroup<String> testConductedNasal;
    private RadioButtonGroup<String> pcrResultNasalThroatNp;
    private RadioButtonGroup<String> genoSequencingPcr;
    private DatePicker dateResultReleasedPcr;
    private RadioButtonGroup<String> rdtResultNasalThroatNp;
    private RadioButtonGroup<String> genoSequencingRdt;
    private DatePicker dateResultReleasedRdt;

    // Blood
    private RadioButtonGroup<String> bloodSpecimenReceived;
    private RadioButtonGroup<String> specimenConditionBlood;
    private CheckboxGroup<String> testConductedBlood;
    private RadioButtonGroup<String> serologyResultBlood;

    public Covid19LaboratoryInformationView() {
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
                new FormLayout.ResponsiveStep("900px", 2),
                new FormLayout.ResponsiveStep("1200px", 3)
        );

        specimenCollected = createRadioGroup("Specimen collected", true, "yes", "no");
        dateSpecimenCollected = new DatePicker("Date specimen collected");
        dateSpecimenCollected.setMax(LocalDate.now());
        dateSpecimenCollected.setVisible(false);

        specimenType = new CheckboxGroup<>("Type of specimen collected?");
        specimenType.setItems("Nasal swab", "Throat swab", "Nasopharyngea", "Blood");
        specimenType.setVisible(false);

        dateSpecimenSent = new DatePicker("Date specimen sent");
        dateSpecimenSent.setMax(LocalDate.now());
        dateSpecimenSent.setVisible(false);

        nameOfTestingLaboratory = new ComboBox<>("Name Of testing laboratory");
        nameOfTestingLaboratory.setItems(testingLaboratoryData);
        nameOfTestingLaboratory.setVisible(false);

        // Nasal/Throat/NP
        nSwabSpecimenReceived = createRadioGroup("Nasal swab", true, "yes", "no");
        nSwabSpecimenReceived.setVisible(false);
        tSwabSpecimenReceived = createRadioGroup("Throat swab", true, "yes", "no");
        tSwabSpecimenReceived.setVisible(false);
        npSwabSpecimenReceived = createRadioGroup("Nasopharyngea swab", true, "yes", "no");
        npSwabSpecimenReceived.setVisible(false);

        dateSecimenReceivedNasalThroatNp = new DatePicker("Date specimen received");
        dateSecimenReceivedNasalThroatNp.setMax(LocalDate.now());
        dateSecimenReceivedNasalThroatNp.setVisible(false);

        laboratoryIdNasalThroatNp = new TextField("Laboratory ID");
        laboratoryIdNasalThroatNp.setVisible(false);

        specimenConditionNasalThroatNp = createRadioGroup("Specimen condition", true, "adequate", "not adequate");
        specimenConditionNasalThroatNp.setVisible(false);

        testConductedNasal = new CheckboxGroup<>("Test conducted");
        testConductedNasal.setItems("PCR", "RDT", "serology");
        testConductedNasal.setVisible(false);

        pcrResultNasalThroatNp = createRadioGroup("PCR result", true, "positive", "negative", "indeterminate", "pending", "not done");
        pcrResultNasalThroatNp.setVisible(false);

        genoSequencingPcr = createRadioGroup("Genomic sequencing PCR", false, "B.1.1.7", "B.1.351", "P.1", "B.1.617.2");
        genoSequencingPcr.setVisible(false);

        dateResultReleasedPcr = new DatePicker("Date PCR result released");
        dateResultReleasedPcr.setMax(LocalDate.now());
        dateResultReleasedPcr.setVisible(false);

        rdtResultNasalThroatNp = createRadioGroup("RDT result", true, "positive", "negative", "indeterminate", "pending", "not done");
        rdtResultNasalThroatNp.setVisible(false);

        genoSequencingRdt = createRadioGroup("Genomic sequencing RDT", false, "B.1.1.7", "B.1.351", "P.1", "B.1.617.2");
        genoSequencingRdt.setVisible(false);

        dateResultReleasedRdt = new DatePicker("Date RDT result released");
        dateResultReleasedRdt.setMax(LocalDate.now());
        dateResultReleasedRdt.setVisible(false);

        // Blood
        bloodSpecimenReceived = createRadioGroup("Blood specimen received", true, "yes", "no");
        bloodSpecimenReceived.setVisible(false);

        specimenConditionBlood = createRadioGroup("Specimen condition", true, "adequate", "not adequate");
        specimenConditionBlood.setVisible(false);

        testConductedBlood = new CheckboxGroup<>("Test conducted");
        testConductedBlood.setItems("PCR", "serology");
        testConductedBlood.setVisible(false);

        serologyResultBlood = createRadioGroup("Serology result", true, "igm positive", "igm negative", "igm indeterminate", "pending", "not done");
        serologyResultBlood.setVisible(false);

        // Dynamic logic
        specimenCollected.addValueChangeListener(e -> {
            boolean yes = "yes".equals(e.getValue());
            dateSpecimenCollected.setVisible(yes);
            specimenType.setVisible(yes);
            nameOfTestingLaboratory.setVisible(yes);
        });

        specimenType.addValueChangeListener(e -> {
            List<String> types = new ArrayList<>(specimenType.getValue());
            boolean hasNasal = types.contains("Nasal swab");
            boolean hasThroat = types.contains("Throat swab");
            boolean hasNP = types.contains("Nasopharyngea");
            boolean hasBlood = types.contains("Blood");
            boolean anySwab = hasNasal || hasThroat || hasNP;

            dateSpecimenSent.setVisible(types.size() >= 1);

            nSwabSpecimenReceived.setVisible(hasNasal);
            tSwabSpecimenReceived.setVisible(hasThroat);
            npSwabSpecimenReceived.setVisible(hasNP);

            // Show swab result section if any swab is selected and received
            boolean showSwabResultSection =
                    (hasNasal && "yes".equals(nSwabSpecimenReceived.getValue())) ||
                    (hasThroat && "yes".equals(tSwabSpecimenReceived.getValue())) ||
                    (hasNP && "yes".equals(npSwabSpecimenReceived.getValue()));

            dateSecimenReceivedNasalThroatNp.setVisible(showSwabResultSection);
            laboratoryIdNasalThroatNp.setVisible(showSwabResultSection);
            specimenConditionNasalThroatNp.setVisible(showSwabResultSection);
            testConductedNasal.setVisible(showSwabResultSection);

            // Blood
            bloodSpecimenReceived.setVisible(hasBlood);
        });

        nSwabSpecimenReceived.addValueChangeListener(e -> updateSwabResultSection());
        tSwabSpecimenReceived.addValueChangeListener(e -> updateSwabResultSection());
        npSwabSpecimenReceived.addValueChangeListener(e -> updateSwabResultSection());

        testConductedNasal.addValueChangeListener(e -> {
            List<String> tests = new ArrayList<>(testConductedNasal.getValue());
            boolean hasPCR = tests.contains("PCR");
            boolean hasRDT = tests.contains("RDT");

            pcrResultNasalThroatNp.setVisible(hasPCR);
            dateResultReleasedPcr.setVisible(hasPCR);

            rdtResultNasalThroatNp.setVisible(hasRDT);
            dateResultReleasedRdt.setVisible(hasRDT);
        });

        pcrResultNasalThroatNp.addValueChangeListener(e -> {
            boolean show = "positive".equals(e.getValue());
            genoSequencingPcr.setVisible(show);
        });

        rdtResultNasalThroatNp.addValueChangeListener(e -> {
            boolean show = "positive".equals(e.getValue());
            genoSequencingRdt.setVisible(show);
        });

        bloodSpecimenReceived.addValueChangeListener(e -> {
            boolean yes = "yes".equals(e.getValue());
            specimenConditionBlood.setVisible(yes);
            testConductedBlood.setVisible(yes);
        });

        testConductedBlood.addValueChangeListener(e -> {
            List<String> tests = new ArrayList<>(testConductedBlood.getValue());
            boolean hasSerology = tests.contains("serology");
            serologyResultBlood.setVisible(hasSerology);
        });

        // Add all fields to the form
        form.add(
                specimenCollected,
                dateSpecimenCollected,
                specimenType,
                dateSpecimenSent,
                nameOfTestingLaboratory,
                nSwabSpecimenReceived,
                tSwabSpecimenReceived,
                npSwabSpecimenReceived,
                dateSecimenReceivedNasalThroatNp,
                laboratoryIdNasalThroatNp,
                specimenConditionNasalThroatNp,
                testConductedNasal,
                pcrResultNasalThroatNp,
                genoSequencingPcr,
                dateResultReleasedPcr,
                rdtResultNasalThroatNp,
                genoSequencingRdt,
                dateResultReleasedRdt,
                bloodSpecimenReceived,
                specimenConditionBlood,
                testConductedBlood,
                serologyResultBlood
        );

        return form;
    }

    private void updateSwabResultSection() {
        List<String> types = new ArrayList<>(specimenType.getValue());
        boolean hasNasal = types.contains("Nasal swab") && "yes".equals(nSwabSpecimenReceived.getValue());
        boolean hasThroat = types.contains("Throat swab") && "yes".equals(tSwabSpecimenReceived.getValue());
        boolean hasNP = types.contains("Nasopharyngea") && "yes".equals(npSwabSpecimenReceived.getValue());
        boolean show = hasNasal || hasThroat || hasNP;

        dateSecimenReceivedNasalThroatNp.setVisible(show);
        laboratoryIdNasalThroatNp.setVisible(show);
        specimenConditionNasalThroatNp.setVisible(show);
        testConductedNasal.setVisible(show);
    }

    private RadioButtonGroup<String> createRadioGroup(String label, boolean required, String... items) {
        RadioButtonGroup<String> group = new RadioButtonGroup<>(label);
        group.setItems(items);
        if (required) {
            group.setRequired(true);
            group.setRequiredIndicatorVisible(true);
        }
        return group;
    }
}

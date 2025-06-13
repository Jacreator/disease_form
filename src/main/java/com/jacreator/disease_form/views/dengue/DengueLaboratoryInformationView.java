package com.jacreator.disease_form.views.dengue;

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

public class DengueLaboratoryInformationView extends VerticalLayout {
private RadioButtonGroup<String> sampleCollected;
    private DatePicker dateSpecimenCollected;
    private CheckboxGroup<String> sampleType;
    private DatePicker dateSpecimenSent;
    private ComboBox<String> nameOfTestingLaboratory;

    // Blood sample fields
    private RadioButtonGroup<String> bloodSampleReceived;
    private DatePicker bloodDateSpecimenReceived;
    private RadioButtonGroup<String> bloodSampleCondition;
    private CheckboxGroup<String> bloodTestConducted;
    private RadioButtonGroup<String> bloodIgmResult;
    private DatePicker bloodIgmDateResultAvailable;
    private DatePicker bloodIgmDateResultSent;
    // ... (other blood test result fields as needed)

    // Sera sample fields
    private RadioButtonGroup<String> seraSampleReceived;
    private DatePicker seraDateSpecimenReceived;
    private RadioButtonGroup<String> seraSampleCondition;
    private CheckboxGroup<String> seraTestConducted;
    private RadioButtonGroup<String> seraIgmResult;
    private DatePicker seraIgmDateResultAvailable;
    private DatePicker seraIgmDateResultSent;
    // ... (other sera test result fields as needed)

    private static final List<String> TESTING_LABORATORY_DATA = Arrays.asList(
            "NRL, Gaduwa", "CPHL", "YDMH", "UBTH", "MAITAMA DISTRICT HOSPITAL LABORATORY",
            "GOMBE SPECIALIST HOSPITAL", "MAITAMA DISTRICT HOSPITAL LABORATORY", "UNTH"
    );

    public DengueLaboratoryInformationView() {
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

        sampleCollected = new RadioButtonGroup<>("Sample Collected");
        sampleCollected.setItems("yes", "no", "unknown");
        sampleCollected.setRequired(true);
        sampleCollected.setRequiredIndicatorVisible(true);

        dateSpecimenCollected = new DatePicker("Date Specimen collected");
        dateSpecimenCollected.setRequired(true);
        dateSpecimenCollected.setRequiredIndicatorVisible(true);
        dateSpecimenCollected.setMax(LocalDate.now());
        dateSpecimenCollected.setVisible(false);

        sampleType = new CheckboxGroup<>("Type of Specimen collected?");
        sampleType.setItems("blood", "sera");
        sampleType.setRequired(true);
        sampleType.setRequiredIndicatorVisible(true);
        sampleType.setVisible(false);

        dateSpecimenSent = new DatePicker("Date Specimen Sent");
        dateSpecimenSent.setRequired(true);
        dateSpecimenSent.setRequiredIndicatorVisible(true);
        dateSpecimenSent.setMax(LocalDate.now());
        dateSpecimenSent.setVisible(false);

        nameOfTestingLaboratory = new ComboBox<>("Name Of Testing Laboratory");
        nameOfTestingLaboratory.setItems(TESTING_LABORATORY_DATA);
        nameOfTestingLaboratory.setRequired(true);
        nameOfTestingLaboratory.setRequiredIndicatorVisible(true);
        nameOfTestingLaboratory.setVisible(false);

        // Blood sample fields
        bloodSampleReceived = new RadioButtonGroup<>("Blood sample received");
        bloodSampleReceived.setItems("yes", "no");
        bloodSampleReceived.setRequired(true);
        bloodSampleReceived.setRequiredIndicatorVisible(true);
        bloodSampleReceived.setVisible(false);

        bloodDateSpecimenReceived = new DatePicker("Date Specimen Received");
        bloodDateSpecimenReceived.setRequired(true);
        bloodDateSpecimenReceived.setRequiredIndicatorVisible(true);
        bloodDateSpecimenReceived.setMax(LocalDate.now());
        bloodDateSpecimenReceived.setVisible(false);

        bloodSampleCondition = new RadioButtonGroup<>("Specimen Condition");
        bloodSampleCondition.setItems("adequate", "not adequate");
        bloodSampleCondition.setRequired(true);
        bloodSampleCondition.setRequiredIndicatorVisible(true);
        bloodSampleCondition.setVisible(false);

        bloodTestConducted = new CheckboxGroup<>("Test Conducted");
        bloodTestConducted.setItems("igm", "iggAcute", "iggConvalescent", "microscopy", "pcrRtPcr");
        bloodTestConducted.setRequired(true);
        bloodTestConducted.setRequiredIndicatorVisible(true);
        bloodTestConducted.setVisible(false);

        bloodIgmResult = new RadioButtonGroup<>("Igm Result");
        bloodIgmResult.setItems("positive", "negative", "inconclusive");
        bloodIgmResult.setRequired(true);
        bloodIgmResult.setRequiredIndicatorVisible(true);
        bloodIgmResult.setVisible(false);

        bloodIgmDateResultAvailable = new DatePicker("Date Result Available");
        bloodIgmDateResultAvailable.setRequired(true);
        bloodIgmDateResultAvailable.setRequiredIndicatorVisible(true);
        bloodIgmDateResultAvailable.setMax(LocalDate.now());
        bloodIgmDateResultAvailable.setVisible(false);

        bloodIgmDateResultSent = new DatePicker("Date Result Sent Out");
        bloodIgmDateResultSent.setRequired(true);
        bloodIgmDateResultSent.setRequiredIndicatorVisible(true);
        bloodIgmDateResultSent.setMax(LocalDate.now());
        bloodIgmDateResultSent.setVisible(false);

        // Sera sample fields (similar to blood, omitted for brevity)
        seraSampleReceived = new RadioButtonGroup<>("Sera sample received");
        seraSampleReceived.setItems("yes", "no");
        seraSampleReceived.setRequired(true);
        seraSampleReceived.setRequiredIndicatorVisible(true);
        seraSampleReceived.setVisible(false);

        seraDateSpecimenReceived = new DatePicker("Date Specimen Received");
        seraDateSpecimenReceived.setRequired(true);
        seraDateSpecimenReceived.setRequiredIndicatorVisible(true);
        seraDateSpecimenReceived.setMax(LocalDate.now());
        seraDateSpecimenReceived.setVisible(false);

        seraSampleCondition = new RadioButtonGroup<>("Specimen Condition");
        seraSampleCondition.setItems("adequate", "not adequate");
        seraSampleCondition.setRequired(true);
        seraSampleCondition.setRequiredIndicatorVisible(true);
        seraSampleCondition.setVisible(false);

        seraTestConducted = new CheckboxGroup<>("Test Conducted");
        seraTestConducted.setItems("igm", "iggAcute", "iggConvalescent", "microscopy", "pcrRtPcr");
        seraTestConducted.setRequired(true);
        seraTestConducted.setRequiredIndicatorVisible(true);
        seraTestConducted.setVisible(false);

        seraIgmResult = new RadioButtonGroup<>("Igm Result");
        seraIgmResult.setItems("positive", "negative", "inconclusive");
        seraIgmResult.setRequired(true);
        seraIgmResult.setRequiredIndicatorVisible(true);
        seraIgmResult.setVisible(false);

        seraIgmDateResultAvailable = new DatePicker("Date Result Available");
        seraIgmDateResultAvailable.setRequired(true);
        seraIgmDateResultAvailable.setRequiredIndicatorVisible(true);
        seraIgmDateResultAvailable.setMax(LocalDate.now());
        seraIgmDateResultAvailable.setVisible(false);

        seraIgmDateResultSent = new DatePicker("Date Result Sent Out");
        seraIgmDateResultSent.setRequired(true);
        seraIgmDateResultSent.setRequiredIndicatorVisible(true);
        seraIgmDateResultSent.setMax(LocalDate.now());
        seraIgmDateResultSent.setVisible(false);

        // Dynamic logic for showing/hiding fields
        sampleCollected.addValueChangeListener(e -> {
            boolean collected = "yes".equals(e.getValue());
            dateSpecimenCollected.setVisible(collected);
            sampleType.setVisible(collected);
            dateSpecimenSent.setVisible(collected);
            nameOfTestingLaboratory.setVisible(collected);

            if (!collected) {
                dateSpecimenCollected.clear();
                sampleType.clear();
                dateSpecimenSent.clear();
                nameOfTestingLaboratory.clear();
            }
        });

        sampleType.addValueChangeListener(e -> {
            Set<String> types = e.getValue();
            boolean hasBlood = types.contains("blood");
            boolean hasSera = types.contains("sera");

            bloodSampleReceived.setVisible(hasBlood);
            seraSampleReceived.setVisible(hasSera);

            if (!hasBlood) {
                bloodSampleReceived.clear();
            }
            if (!hasSera) {
                seraSampleReceived.clear();
            }
        });

        bloodSampleReceived.addValueChangeListener(e -> {
            boolean received = "yes".equals(e.getValue());
            bloodDateSpecimenReceived.setVisible(received);
            bloodSampleCondition.setVisible(received);
            bloodTestConducted.setVisible(received);

            if (!received) {
                bloodDateSpecimenReceived.clear();
                bloodSampleCondition.clear();
                bloodTestConducted.clear();
            }
        });

        bloodTestConducted.addValueChangeListener(e -> {
            Set<String> tests = e.getValue();
            boolean igm = tests.contains("igm");
            bloodIgmResult.setVisible(igm);
            bloodIgmDateResultAvailable.setVisible(igm);
            bloodIgmDateResultSent.setVisible(igm);

            if (!igm) {
                bloodIgmResult.clear();
                bloodIgmDateResultAvailable.clear();
                bloodIgmDateResultSent.clear();
            }
            // Add similar logic for other tests as needed
        });

        seraSampleReceived.addValueChangeListener(e -> {
            boolean received = "yes".equals(e.getValue());
            seraDateSpecimenReceived.setVisible(received);
            seraSampleCondition.setVisible(received);
            seraTestConducted.setVisible(received);

            if (!received) {
                seraDateSpecimenReceived.clear();
                seraSampleCondition.clear();
                seraTestConducted.clear();
            }
        });

        seraTestConducted.addValueChangeListener(e -> {
            Set<String> tests = e.getValue();
            boolean igm = tests.contains("igm");
            seraIgmResult.setVisible(igm);
            seraIgmDateResultAvailable.setVisible(igm);
            seraIgmDateResultSent.setVisible(igm);

            if (!igm) {
                seraIgmResult.clear();
                seraIgmDateResultAvailable.clear();
                seraIgmDateResultSent.clear();
            }
            // Add similar logic for other tests as needed
        });

        // Add all fields to the form
        form.add(
                sampleCollected,
                dateSpecimenCollected,
                sampleType,
                dateSpecimenSent,
                nameOfTestingLaboratory,
                bloodSampleReceived,
                bloodDateSpecimenReceived,
                bloodSampleCondition,
                bloodTestConducted,
                bloodIgmResult,
                bloodIgmDateResultAvailable,
                bloodIgmDateResultSent,
                seraSampleReceived,
                seraDateSpecimenReceived,
                seraSampleCondition,
                seraTestConducted,
                seraIgmResult,
                seraIgmDateResultAvailable,
                seraIgmDateResultSent
        );

        return form;
    }
}

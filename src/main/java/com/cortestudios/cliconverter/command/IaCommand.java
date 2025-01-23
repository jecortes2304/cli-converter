package com.cortestudios.cliconverter.command;

import com.cortestudios.cliconverter.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.component.view.control.ProgressView;
import org.springframework.shell.component.view.control.ProgressView.ProgressViewItem;
import org.springframework.shell.geom.HorizontalAlign;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class IaCommand {

    private final ConversionService conversionService;

    @ShellMethod(key = "convert", value = "This will convert your input to your output format option.")
    public String convert(
            @ShellOption(value = {"--input-data", "-id"}, help = "The data you want to convert.") String inputData,
            @ShellOption(value = {"--input-format", "-if"}, help = "The format of the input data, e.g., 'java'.") String inputFormat,
            @ShellOption(value = {"--output-format", "-of"}, help = "The desired format of the output data, e.g., 'openapi'.") String outputFormat) {

        return conversionService.convert(inputData, inputFormat, outputFormat);
    }


    @ShellMethod(key = "--test", value = "Testing this")
    public void testing() {
        ProgressViewItem textItem = ProgressViewItem.ofText(20, HorizontalAlign.LEFT);
        ProgressViewItem spinnerItem = ProgressViewItem.ofSpinner(3, HorizontalAlign.LEFT);
        ProgressViewItem percentItem = ProgressViewItem.ofPercent(5, HorizontalAlign.RIGHT);

        ProgressView progressView = new ProgressView(textItem, spinnerItem, percentItem);
        progressView.setDescription("Executing task...");

        try {
            progressView.start();
            for (int i = 0; i <= 10; i++) {
                progressView.setTickValue(i * 10);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            progressView.stop();
        }
    }
}

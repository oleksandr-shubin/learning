package com.shubin.model.computer.program.filemanager;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class FileManagerTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private FileManager fileManager;

    @Before
    public void setUp() {
        fileManager = new FileManager();
    }

    @Test
    public void testCopyShouldPrintErrorWhenParameterFilesDoNotExist() {
        File source = new File("");
        File destination = new File("");

        //ensure, that files do not exist
        if (source.exists() || destination.exists()) {
            throw new IllegalStateException("Not all files are non-existent");
        }

        compareCopyErrorOutput(source, destination);
    }

    @Test
    public void testCopyShouldPrintErrorWhenSourceFileDoesNotExist() throws IOException {
        File source = new File("");
        File destination = folder.newFile("second.txt");

        // ensure only destination file exists
        if (source.exists() && !destination.exists()) {
            throw new IllegalStateException();
        }

        compareCopyErrorOutput(source, destination);
    }

    @Test
    public void testCopyShouldPrintErrorWhenDestinationFileDoesNotExist() throws IOException {
        File source = folder.newFile("first.txt");
        File destination = new File("");

        // ensure only source file exists
        if (!source.exists() && destination.exists()) {
            throw new IllegalStateException();
        }

        compareCopyErrorOutput(source, destination);
    }

    private void compareCopyErrorOutput(File source, File destination) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String expectedOutput = "Create files before you do copy\n";
        System.setErr(new PrintStream(outContent));

        fileManager.copy(source, destination);

        assertThat(outContent.toString(), is(equalTo(expectedOutput)));
    }

    @Test
    public void testCopyShouldCopyDataFromSourceToDestinationFile() throws IOException {
        File source = folder.newFile("first.txt");
        File destination = folder.newFile("second.txt");
        String data = "test data";
        String encoding = "UTF-8";

        FileUtils.writeStringToFile(source, data, encoding);
        fileManager.copy(source, destination);
        String dataCopied = FileUtils.readFileToString(destination, encoding);

        // assert error
        assertThat(dataCopied, is(equalTo(data)));
    }


}
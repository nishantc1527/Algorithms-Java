package com.nishant.algorithms.NeuralNetworks.MNISTData;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.io.*;

/**
 * A class for reading the MNIST data set from the <b>decompressed</b>
 * (unzipped) files that are published at
 * <a href="http://yann.lecun.com/exdb/mnist/">
 * http://yann.lecun.com/exdb/mnist/</a>.
 */
public class MnistLoader
{
    /**
     * Default constructor
     */
    public MnistLoader()
    {
        // Default constructor
    }

    /**
     * Read the MNIST training data from the given directory. The data is
     * assumed to be located in files with their default names,
     * <b>decompressed</b> from the original files:
     * extension) :
     * <code>train-images.idx3-ubyte</code> and
     * <code>train-labels.idx1-ubyte</code>.
     *
     * @param inputDirectoryPath The input directory
     * {@link MnistEntry} instances
     * @throws IOException If an IO error occurs
     */
    public MnistEntry[] readDecompressedTraining(String inputDirectoryPath) throws IOException
    {
        String trainImagesFileName = "train-images.idx3-ubyte";
        String trainLabelsFileName = "train-labels.idx1-ubyte";
        String imagesFilePath = inputDirectoryPath + "\\" + trainImagesFileName;
        String labelsFilePath = inputDirectoryPath + "\\" + trainLabelsFileName;
        return readDecompressed(imagesFilePath, labelsFilePath);
    }

    /**
     * Read the MNIST training data from the given directory. The data is
     * assumed to be located in files with their default names,
     * <b>decompressed</b> from the original files:
     * extension) :
     * <code>t10k-images.idx3-ubyte</code> and
     * <code>t10k-labels.idx1-ubyte</code>.
     *
     * @param inputDirectoryPath The input directory
     * {@link MnistEntry} instances
     * @throws IOException If an IO error occurs
     */
    public MnistEntry[] readDecompressedTesting(String inputDirectoryPath) throws IOException
    {
        String trainImagesFileName = "t10k-images.idx3-ubyte";
        String trainLabelsFileName = "t10k-labels.idx1-ubyte";
        String imagesFilePath = inputDirectoryPath + "\\" + trainImagesFileName;
        String labelsFilePath = inputDirectoryPath + "\\" + trainLabelsFileName;
        return readDecompressed(imagesFilePath, labelsFilePath);
    }


    /**
     * Read the MNIST data from the specified (decompressed) files.
     *
     * @param imagesFilePath The path of the images file
     * @param labelsFilePath The path of the labels file
     * {@link MnistEntry} instances
     * @throws IOException If an IO error occurs
     */
    public MnistEntry[] readDecompressed(String imagesFilePath, String labelsFilePath) throws IOException
    {
        try (InputStream decompressedImagesInputStream =
                     new FileInputStream(new File(imagesFilePath));
             InputStream decompressedLabelsInputStream =
                     new FileInputStream(new File(labelsFilePath)))
        {
            return readDecompressed(
                    decompressedImagesInputStream,
                    decompressedLabelsInputStream);
        }
    }

    /**
     * Read the MNIST data from the given (decompressed) input streams.
     * The caller is responsible for closing the given streams.
     *
     * @param decompressedImagesInputStream The decompressed input stream
     * containing the image data
     * @param decompressedLabelsInputStream The decompressed input stream
     * containing the label data
     * {@link MnistEntry} instances
     * @throws IOException If an IO error occurs
     */
    public MnistEntry[] readDecompressed(
            InputStream decompressedImagesInputStream,
            InputStream decompressedLabelsInputStream) throws IOException
    {
        DataInputStream imagesDataInputStream =
                new DataInputStream(decompressedImagesInputStream);
        DataInputStream labelsDataInputStream =
                new DataInputStream(decompressedLabelsInputStream);

        int magicImages = imagesDataInputStream.readInt();
        if (magicImages != 0x803)
        {
            throw new IOException("Expected magic header of 0x803 "
                    + "for images, but found " + magicImages);
        }

        int magicLabels = labelsDataInputStream.readInt();
        if (magicLabels != 0x801)
        {
            throw new IOException("Expected magic header of 0x801 "
                    + "for labels, but found " + magicLabels);
        }

        int numberOfImages = imagesDataInputStream.readInt();
        int numberOfLabels = labelsDataInputStream.readInt();

        if (numberOfImages != numberOfLabels)
        {
            throw new IOException("Found " + numberOfImages
                    + " images but " + numberOfLabels + " labels");
        }

        int numRows = imagesDataInputStream.readInt();
        int numCols = imagesDataInputStream.readInt();

        MnistEntry[] mnistEntries = new MnistEntry[numberOfImages];

        for (int n = 0; n < numberOfImages; n++)
        {
            byte label = labelsDataInputStream.readByte();
            byte[] imageData = new byte[numRows * numCols];
            read(imagesDataInputStream, imageData);

            MnistEntry mnistEntry = new MnistEntry(
                    n, label, numRows, numCols, imageData);
            mnistEntries[n] = mnistEntry;
        }

        return mnistEntries;
    }

    /**
     * Read bytes from the given input stream, filling the given array
     *
     * @param inputStream The input stream
     * @param data The array to be filled
     * @throws IOException If the input stream does not contain enough bytes
     * to fill the array, or any other IO error occurs
     */
    private static void read(InputStream inputStream, byte[] data)
            throws IOException
    {
        int offset = 0;
        while (true)
        {
            int read = inputStream.read(
                    data, offset, data.length - offset);
            if (read < 0)
            {
                break;
            }
            offset += read;
            if (offset == data.length)
            {
                return;
            }
        }
        throw new IOException("Tried to read " + data.length
                + " bytes, but only found " + offset);
    }
}
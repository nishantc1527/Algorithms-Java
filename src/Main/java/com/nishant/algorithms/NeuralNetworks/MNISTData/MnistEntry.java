package com.nishant.algorithms.NeuralNetworks.MNISTData;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;

/**
 * An entry of the MNIST data set. Instances of this class will be passed
 * to the consumer that is given to the {@link MnistLoader} and
 * {@link MnistLoader} reading methods.
 */
public class MnistEntry
{
    /**
     * The index of the entry
     */
    private final int index;

    /**
     * The class label of the entry
     */
    private final byte label;

    /**
     * The number of rows of the image data
     */
    private final int numRows;

    /**
     * The number of columns of the image data
     */
    private final int numCols;

    /**
     * The image data
     */
    private final byte[] imageData;

    /**
     * Default constructor
     *
     * @param index The index
     * @param label The label
     * @param numRows The number of rows
     * @param numCols The number of columns
     * @param imageData The image data
     */
    MnistEntry(int index, byte label, int numRows, int numCols,
               byte[] imageData)
    {
        this.index = index;
        this.label = label;
        this.numRows = numRows;
        this.numCols = numCols;
        this.imageData = imageData;
    }

    /**
     * Returns the index of the entry
     *
     * @return The index
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * Returns the class label of the entry. This is a value in [0,9],
     * indicating which digit is shown in the entry
     *
     * @return The class label
     */
    public byte getLabel()
    {
        return label;
    }

    /**
     * Returns the number of rows of the image data.
     * This will usually be 28.
     *
     * @return The number of rows
     */
    public int getNumRows()
    {
        return numRows;
    }

    /**
     * Returns the number of columns of the image data.
     * This will usually be 28.
     *
     * @return The number of columns
     */
    public int getNumCols()
    {
        return numCols;
    }

    /**
     * Returns a <i>reference</i> to the image data. This will be an array
     * of length <code>numRows * numCols</code>, containing values
     * in [0,255] indicating the brightness of the pixels.
     *
     * @return The image data
     */
    public byte[] getImageData()
    {
        return imageData;
    }

    /**
     * Creates a new buffered image from the image data that is stored
     * in this entry.
     *
     * @return The image
     */
    public BufferedImage createImage()
    {
        BufferedImage image = new BufferedImage(getNumCols(),
                getNumRows(), BufferedImage.TYPE_BYTE_GRAY);
        DataBuffer dataBuffer = image.getRaster().getDataBuffer();
        DataBufferByte dataBufferByte = (DataBufferByte) dataBuffer;
        byte[] data = dataBufferByte.getData();
        System.arraycopy(getImageData(), 0, data, 0, data.length);
        return image;
    }


    @Override
    public String toString()
    {
        String indexString = String.format("%05d", index);
        return "MnistEntry["
                + "index=" + indexString + ","
                + "label=" + label + "]";
    }

}
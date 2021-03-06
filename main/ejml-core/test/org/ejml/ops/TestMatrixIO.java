/*
 * Copyright (c) 2009-2017, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Efficient Java Matrix Library (EJML).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ejml.ops;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.MatrixFeatures_DDRM;
import org.ejml.dense.row.RandomMatrices_DDRM;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertTrue;


/**
 * @author Peter Abeles
 */
public class TestMatrixIO {

    Random rand = new Random(23424);

    @Test
    public void load_save_binary() throws IOException {
        DMatrixRMaj A = RandomMatrices_DDRM.rectangle(6,3,rand);

        MatrixIO.saveBin(A, "temp.mat");

        DMatrixRMaj A_copy = MatrixIO.loadBin("temp.mat");

        assertTrue(A != A_copy);
        assertTrue(MatrixFeatures_DDRM.isEquals(A,A_copy));

        // clean up
        File f = new File("temp.mat");
        assertTrue(f.exists());
        assertTrue(f.delete());
    }

    @Test
    public void load_save_csv() throws IOException {
        DMatrixRMaj A = RandomMatrices_DDRM.rectangle(6,3,rand);

        MatrixIO.saveCSV(A,"temp.csv");

        DMatrixRMaj A_copy = MatrixIO.loadCSV("temp.csv");

        assertTrue(A != A_copy);
        assertTrue(MatrixFeatures_DDRM.isEquals(A,A_copy));

        // clean up
        File f = new File("temp.csv");
        assertTrue(f.exists());
        assertTrue(f.delete());
    }
}

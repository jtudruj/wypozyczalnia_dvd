package com.rzonca.barbara.zaliczenie.controller;

import com.rzonca.barbara.zaliczenie.errors.DiscStorageException;
import com.rzonca.barbara.zaliczenie.model.DiscModel;

import java.io.IOException;
import java.util.List;

interface DiscControllerContract {
    public void add(DiscModel model);

    public void removeItemTitled(String title) throws DiscStorageException;

    public List<DiscModel> getList() throws DiscStorageException;

    public List<DiscModel> getListFilteredByText(String filterText) throws DiscStorageException;

    public List<DiscModel> getListOrderedByColumn(String columnNumber) throws DiscStorageException;

    public void exportListToFileWithDirectory(String directory) throws Exception;

    public void importListFromFileAtDirectory(String directory) throws Exception;
}

package com.rzonca.barbara.zaliczenie.controller;

import com.rzonca.barbara.zaliczenie.DiscStorage;
import com.rzonca.barbara.zaliczenie.FileHandler;
import com.rzonca.barbara.zaliczenie.errors.DiscStorageException;
import com.rzonca.barbara.zaliczenie.errors.DiscStorageExceptionType;
import com.rzonca.barbara.zaliczenie.model.DiscModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiscController implements DiscControllerContract {

    @Override
    public void add(DiscModel model) {
        DiscStorage.getInstance().getDiscs().add(model);
    }

    @Override
    public void removeItemTitled(String title) throws DiscStorageException {
        List<DiscModel> allDiscs = getList();
        DiscModel foundDisc = null;
        for (DiscModel disc: allDiscs) {
            if (disc.getTitle().equals(title)) {
                foundDisc = disc;
            }
        }
        if (foundDisc == null) {
            throw new DiscStorageException(DiscStorageExceptionType.REMOVE_ERROR_LIST_NO_CONTAINS);
        }
        DiscStorage.getInstance().getDiscs().remove(foundDisc);
    }

    @Override
    public List<DiscModel> getList() throws DiscStorageException {
        List<DiscModel> list = DiscStorage.getInstance().getDiscs();
        if (list == null || list.isEmpty()) {
            throw new DiscStorageException(DiscStorageExceptionType.LIST_EMPTY);
        }
        return DiscStorage.getInstance().getDiscs();
    }

    @Override
    public List<DiscModel> getListFilteredByText(String filterText) throws DiscStorageException {
        List<DiscModel> allDiscs = getList();
        List<DiscModel> filteredList = new ArrayList<DiscModel>();
        for (DiscModel disc: allDiscs) {
            if (disc.containsText(filterText)) {
                filteredList.add(disc);
            }
        }
        if (filteredList.isEmpty()) {
            throw new DiscStorageException(DiscStorageExceptionType.FILTERED_LIST_EMPTY);
        }
        return filteredList;
    }

    @Override
    public List<DiscModel> getListOrderedByColumn(String columnNumber) throws DiscStorageException {
        Integer number = Integer.parseInt(columnNumber);
        if (number == null) {
            throw new DiscStorageException(DiscStorageExceptionType.INVALID_COLUMN_TYPE);
        }
        List<DiscModel> newList = new ArrayList<>(getList());
        switch (number) {
            case 1:
                newList.sort(Comparator.comparing(DiscModel::getTitle));
                break;
            case 2:
                newList.sort(Comparator.comparing(DiscModel::getLender));
                break;
            case 3:
                newList.sort(Comparator.comparing(DiscModel::getLendDate));
                break;
            default:
                throw new DiscStorageException(DiscStorageExceptionType.INVALID_COLUMN_NUMBER);
        }
        return newList;
    }

    @Override
    public void exportListToFileWithDirectory(String directory) throws Exception {
        FileHandler.saveListToDirectory(DiscStorage.getInstance().getDiscs(), directory);

    }

    @Override
    public void importListFromFileAtDirectory(String directory) throws Exception{
        DiscStorage.getInstance().overrideListWith(FileHandler.getListFromDirectory(directory));
    }
}

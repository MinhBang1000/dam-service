package ctu.cit.se.dam_service.migrations;

import java.util.List;

public interface IBaseInitData<T> {
    List<T> getInitData();
}

package com.officialsounding.findbout.dao;

import com.officialsounding.findbout.dao.mapper.BoutMapper;
import com.officialsounding.findbout.model.Bout;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(BoutMapper.class)
public interface BoutDAO {

    @SqlQuery("select date, sanctioned_by, "+
              "home.id as home_id, home.name as home_name, home.location_text as home_location, home.lat as home_lat, home.lng as home_lng, home.url as home_url, "+
              "away.id as away_id, away.name as away_name, away.location_text as away_location, away.lat as away_lat, away.lng as away_lng, away.url as away_url "+
              "from bout "+
              "join team as home on home.id = home_team_id "+
              "join team as away on away.id = away_team_id order by date LIMIT 100")
    List<Bout> getAll();

    @SqlQuery("select date, sanctioned_by, "+
            "home.id as home_id, home.name as home_name, home.location_text as home_location, home.lat as home_lat, home.lng as home_lng, home.url as home_url, "+
            "away.id as away_id, away.name as away_name, away.location_text as away_location, away.lat as away_lat, away.lng as away_lng, away.url as away_url, "+
            "earth_distance(ll_to_earth(:lat, :lng), ll_to_earth(home.lat, home.lng)) as distance_from_current_location "+
            "from bout "+
            "join team as home on home.id = home_team_id "+
            "join team as away on away.id = away_team_id "+
            "WHERE earth_distance(ll_to_earth(:lat, :lng), ll_to_earth(home.lat, home.lng)) <= :dist "+
            "ORDER BY distance_from_current_location, date ASC LIMIT 100")
    List<Bout> getPrecise(@Bind("lat") double lat, @Bind("lng") double lng, @Bind("dist") double dist);
}

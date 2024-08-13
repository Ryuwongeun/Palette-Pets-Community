// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import CreateIcon from "@mui/icons-material/Create";
import "./../styles/layout/footer.css"

import CurrencyExchangeIcon from "@mui/icons-material/CurrencyExchange";
import {
  BottomNavigation,
  BottomNavigationAction,
  CssBaseline,
  Paper,
  IconButton,
} from "@mui/material";
import {
  Archive,
  Favorite,
  LocationOn,
  Home,
  KeyboardArrowUp,
  VolunteerActivism,
} from "@mui/icons-material";

const Footer = () => {
  const navigate = useNavigate();
  const [value, setValue] = useState(0);
  const [showButton, setShowButton] = useState(false);

  const handleNavigationChange = (event, newValue) => {
    setValue(newValue);
  };

  const moveToTop = () => {
    window.scrollTo({ top: 0, behavior: "smooth" });
  };

  useEffect(() => {
    const handleScroll = () => {
      if (window.scrollY > 100) {
        setShowButton(true);
      } else {
        setShowButton(false);
      }
    };

    window.addEventListener("scroll", handleScroll);

    return () => {
      window.removeEventListener("scroll", handleScroll);
    };
  }, []);

  return (
    <div className={'mainFooter'}>
      <CssBaseline />
      <Paper
        sx={{ position: "fixed", bottom: 0, left: 0, right: 0 }}
        elevation={3}>
        <button className="floating-button"></button>
        <BottomNavigation
          showLabels
          value={value}
          onChange={handleNavigationChange}>
          <BottomNavigationAction
            label="Archive"
            icon={<Archive />}
            onClick={onChat}
          />
          <BottomNavigationAction
            label="PetList"
            icon={<Favorite />}
            onClick={onPetList}
          />
          <BottomNavigationAction
            label="Home"
            icon={<Home />}
            onClick={onHome}
          />
          <BottomNavigationAction
            label="Market"
            icon={<VolunteerActivism />}
            onClick={onCarrot}
          />
          <BottomNavigationAction
            label="Location On"
            icon={<LocationOn />}
            onClick={onHotSpot}
          />
        </BottomNavigation>
        <Link to="/article/write">
          <button className="floating-button">
            <CreateIcon />
          </button>
        </Link>
      </Paper>
      {showButton && (
        <IconButton
          className={"topButton"}
          onClick={moveToTop}
          aria-label="move to top">
          <KeyboardArrowUp />
        </IconButton>
      )}
    </div>
  );
};

export default Footer;

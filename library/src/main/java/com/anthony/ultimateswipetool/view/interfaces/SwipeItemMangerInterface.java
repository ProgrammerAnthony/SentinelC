package com.anthony.ultimateswipetool.view.interfaces;

import com.anthony.ultimateswipetool.view.Attributes;
import com.anthony.ultimateswipetool.view.SwipeViewLayout;


import java.util.List;

public interface SwipeItemMangerInterface {

    void openItem(int position);

    void closeItem(int position);

    void closeAllExcept(SwipeViewLayout layout);
    
    void closeAllItems();

    List<Integer> getOpenItems();

    List<SwipeViewLayout> getOpenLayouts();

    void removeShownLayouts(SwipeViewLayout layout);

    boolean isOpen(int position);

    Attributes.Mode getMode();

    void setMode(Attributes.Mode mode);
}

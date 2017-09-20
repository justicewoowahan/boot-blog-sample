package com.woowahan.blog;

import com.woowahan.blog.commons.ValueCreator;
import com.woowahan.blog.entity.MenuItem;
import com.woowahan.blog.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockEntityHelper {
    @Autowired
    private MenuItemRepository menuItemRepository;



    public MenuItem createMenuItem( MenuItem menuItem, String name) {
        return menuItemRepository.save(MenuItem.createOf(menuItem, name, ValueCreator.randomUrl(), ValueCreator.randomString(4), 0));
    }
}

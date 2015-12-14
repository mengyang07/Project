/*
 * Copyright (c) 2015 Hannes Dorfmann.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.lkmy.library.delegate;

import java.util.List;

/**
 * An adapter implementation designed for items organized in a {@link List}. This adapter
 * implementation is ready to go. All you have to do is to add {@link AdapterDelegate}s to the
 * internal {@link AdapterDelegatesManager} i.e. in the constructor:
 * <p/>
 * <pre>
 * {@code
 *    class MyAdaper extends AbsDelegationAdapter<List<Foo>>{
 *        public MyAdaper(){
 *            this.delegatesManager.add(new FooAdapterDelegate());
 *            this.delegatesManager.add(new BarAdapterDelegate());
 *        }
 *    }
 * }
 * </pre>
 *
 * @param <T> The type of the items. Must be something that extends from List like List<Foo>
 * @author Hannes Dorfmann
 */
public class ListDelegationAdapter<M, T extends List<M>> extends AbsDelegationAdapter<T> {

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();

    }

    /**
     * 在集合头部添加新的数据集合（下拉从服务器获取最新的数据集合，例如新浪微博加载最新的几条微博数据）
     *
     * @param datas
     */
    public void addNewDatas(T datas) {
        if (datas != null) {
            items.addAll(0, datas);
            notifyDataSetChanged();
        }

    }

    /**
     * 在集合尾部添加更多数据集合（上拉从服务器获取更多的数据集合，例如新浪微博列表上拉加载更晚时间发布的微博数据）
     *
     * @param datas
     */
    public void addMoreDatas(T datas) {
        if (datas != null) {
            items.addAll(items.size(), datas);
            notifyDataSetChanged();
        }

    }

    /**
     * 设置全新的数据集合，如果传入null，则清空数据列表（第一次从服务器加载数据，或者下拉刷新当前界面数据表）
     *
     * @param datas
     */
    public void setDatas(T datas) {
        if (datas != null) {
            items = datas;
        } else {
            items.clear();
        }
    }

    /**
     * 清空数据列表
     */
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    /**
     * 删除指定索引数据条目
     *
     * @param position
     */
    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 删除指定数据条目
     *
     * @param model
     */
    public void removeItem(M model) {
        removeItem(items.indexOf(model));
    }

    /**
     * 在指定位置添加数据条目
     *
     * @param position
     * @param model
     */
    public void addItem(int position, M model) {
        items.add(position, model);
        notifyItemInserted(position);
    }

    /**
     * 在集合头部添加数据条目
     *
     * @param model
     */
    public void addFirstItem(M model) {
        addItem(0, model);
        notifyDataSetChanged();
    }

    /**
     * 在集合末尾添加数据条目
     *
     * @param model
     */
    public void addLastItem(M model) {
        addItem(items.size(), model);

    }

    /**
     * 替换指定索引的数据条目
     *
     * @param location
     * @param newModel
     */
    public void setItem(int location, M newModel) {
        items.set(location, newModel);
        notifyItemChanged(location);
    }

    /**
     * 替换指定数据条目
     *
     * @param oldModel
     * @param newModel
     */
    public void setItem(M oldModel, M newModel) {
        setItem(items.indexOf(oldModel), newModel);
        notifyItemChanged(items.indexOf(oldModel));
    }

    /**
     * 移动数据条目的位置
     *
     * @param fromPosition
     * @param toPosition
     */
    public void moveItem(int fromPosition, int toPosition) {
        items.add(toPosition, items.remove(fromPosition));
        notifyItemMoved(fromPosition, toPosition);
    }


}

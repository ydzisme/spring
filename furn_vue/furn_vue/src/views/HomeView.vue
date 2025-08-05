<template>
  <div style="margin: 10px 5px">
    <div style="margin: 10px 5px">
      <el-button type="primary">新增</el-button>
      <el-button type="primary">其它</el-button>
    </div>
    <div>
      <el-input v-model="search" style="width: 30%;" placeholder="请输入关键字"/>
      <el-button style="margin-left: 10px" type="primary">搜索</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column sortable prop="date" label="日期"  />
      <el-table-column prop="name" label="商品名" />
      <el-table-column prop="address" label="生产商" />
      <el-table-column fixed="right" label="操作" min-width="120">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="handleEdit()">
            删除
          </el-button>
          <el-button link type="primary" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  components: {

  },
  data() {
    return{
      search: '',
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  }
}
</script>

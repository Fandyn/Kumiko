var Main = {

    mounted (){
        let that = this;
        axios.post('/axios/queryUserList', {sex: that.formInline.sex})
            .then(function (response) {
                // that.tableData = response.data.list;
                that.total = response.data.total;
                that.handleSizeChange(5);
            }, function (err) {
                that.info = err;
            })
    },

    methods: {
        tableRowClassName({row, rowIndex}) {
            var i = rowIndex;
           //四个一组，筛选奇数，一三各不同
            if (i % 2 == 1) {
                if (i % 3 != 0) {
                    return 'warning-row';
                } else {
                    return 'success-row';
                }
            }
            return '';
        },
        //element似乎只能使用这种格式的方法
        onSubmit() {
            let that = this;
            axios.post('/axios/queryUserList', {sex: that.formInline.sex})
                .then(function (response) {
                    // that.tableData = response.data.list;
                    that.total = response.data.total;
                    that.handleSizeChange(5);
                }, function (err) {
                    that.info = err;
                })
        },
        onSubmitid() {
            let that = this;
            axios.post('/axios/queryUserListByterm', {id: that.formInline.userid,sex: that.formInline.sex})
                .then(function (response) {
                    // that.tableData = response.data.list;
                    that.total = response.data.total;
                    that.handleSizeChange(5);
                }, function (err) {
                    that.info = err;
                })
        },
        fun() {
            let that = this;
            this.onSubmitid();
        },

        handleSizeChange(val) {
            //每页条数
            let that = this;
            this.pageSize = val;
            axios.post('/axios/queryinfo', {id: that.formInline.userid,sex: that.formInline.sex,pageSize:val,pageNum:1})
                .then(function (response) {
                    that.tableData = response.data.list;
                }, function (err) {
                    that.info = err;
                })
            console.log(`每页 ${val} 条`);
        },

        handleCurrentChange(val) {
            //当前页数
            let that = this;
            axios.post('/axios/queryinfo', {id: that.formInline.userid,sex: that.formInline.sex,pageSize:that.pageSize,pageNum:val})
                .then(function (response) {
                    that.tableData = response.data.list;
                }, function (err) {
                    that.info = err;
                })
            console.log(`当前页: ${val}`);
        }
    },
    data() {
        return {
            info:'this is test',
            pageSize:4,
            currentPage:1,
            total:"",
            formInline: {
                userid: '',
                sex: ''
            },
            tableData: []
        }
    }
}
var Ctor = Vue.extend(Main)
// $mount手动挂载
new Ctor().$mount('#app')

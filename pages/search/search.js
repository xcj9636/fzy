  /**
   * author:xcj
   */
  const app=getApp()
  const config=app.config
Page({

  /**
   * 页面的初始数据
   */
  data: {
    wxinfo:'',
    keyword:'',
    isHiddenToast:true
  },
  fzy:function(e){
    var that = this;
    wx.request({
      url: config.host + '/net/',
      data:{
        keyword: e.detail.value.keyword,
        wxinfo:'q',
        flag:'search'
      },
      method:'GET', 
      
      header: {
        'content-type': 'application/x-www-form-urlencoded; charset=UTF-8'
      },
      success: function (res) {
        console.log('success');
        console.log(res.data);
        that.setData({wxinfo:'微信号：\n'+res.data.wxinfo});
        
      },
      fail: function (res) {
        console.log(' fail');
      },
      complete: function (res) {
        
      },
    })
    that.toastChange()
  },
  /**
   * 生命周期函数--监听页面加载
   */
  isShowToast: function () {
    this.setData({
      isHiddenToast: false
    })
  },
  toastChange: function () {
    this.setData({
      isHiddenToast: true
    })
  },
  onLoad: function (options) {
  
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})
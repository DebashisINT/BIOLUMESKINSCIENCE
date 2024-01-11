package com.biolumeaccessfsm.features.contacts

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.NumberPicker
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.Lifecycle
import com.biolumeaccessfsm.R
import com.biolumeaccessfsm.app.AppDatabase
import com.biolumeaccessfsm.app.NetworkConstant
import com.biolumeaccessfsm.app.Pref
import com.biolumeaccessfsm.app.domain.AddShopDBModelEntity
import com.biolumeaccessfsm.app.domain.ModeTemplateEntity
import com.biolumeaccessfsm.app.domain.RuleTemplateEntity
import com.biolumeaccessfsm.app.domain.ScheduleTemplateEntity
import com.biolumeaccessfsm.app.domain.TeamListEntity
import com.biolumeaccessfsm.app.domain.TypeMasterEntity
import com.biolumeaccessfsm.app.utils.AppUtils
import com.biolumeaccessfsm.app.utils.Toaster
import com.biolumeaccessfsm.base.presentation.BaseActivity
import com.biolumeaccessfsm.base.presentation.BaseFragment
import com.biolumeaccessfsm.features.dashboard.presentation.DashboardActivity
import com.biolumeaccessfsm.features.member.api.TeamRepoProvider
import com.google.android.material.textfield.TextInputEditText
import com.pnikosis.materialishprogress.ProgressWheel
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_scheduler_add_form.iv_select_mode_template
import kotlinx.android.synthetic.main.fragment_scheduler_add_form.tv_select_template
import java.text.SimpleDateFormat
import java.util.Calendar


class SchedulerAddFormFrag : BaseFragment(), View.OnClickListener {
    private var str_templateID:String = Pref.user_id!!
    private var str_modeoftemplateID:String = Pref.user_id!!
    private var str_ruleoftemplateID:String = Pref.user_id!!
    private var str_contactoftemplateID:String = Pref.user_id!!
    private var sortBy:String = ""
    private lateinit var progress_wheel: ProgressWheel
    private lateinit var mContext: Context
    private lateinit var hour_numPicker:NumberPicker
    private lateinit var min_numPicker:NumberPicker
    private lateinit var tv_selectedTime:TextView
    private lateinit var schedulername: TextInputEditText
    private lateinit var selectTemplate: TextInputEditText
    private lateinit var et_templateContent: TextInputEditText
    private lateinit var tv_rule_Of_scheduler: TextInputEditText
    private lateinit var selectContactSchedule: TextInputEditText
    private lateinit var selectMode: TextInputEditText
    private lateinit var calendarView : MaterialCalendarView
    private lateinit var cv_calendar : CardView
    private lateinit var sw_repeatmonth : Switch

    private lateinit var iv_template : LinearLayout
    private lateinit var iv_mode_template : LinearLayout
    private lateinit var iv_rule_Of_scheduler_dropdown : LinearLayout
    private lateinit var iv_frag_cont_add_schedule_to : LinearLayout
    private lateinit var cv_frag_Shceduler_add_submit : CardView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    companion object{
        fun getInstance(objects: Any): SchedulerAddFormFrag {
            val objFragment = SchedulerAddFormFrag()
            var obj = objects as String
            return objFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_scheduler_add_form, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        progress_wheel = view.findViewById(R.id.progress_wheel_frag_add_cont)
        cv_calendar = view.findViewById(R.id.cv_calendar)
        hour_numPicker = view.findViewById(R.id.np_frag_schedule_add_form_hr)
        sw_repeatmonth = view.findViewById(R.id.sw_repeatmonth)
        schedulername = view.findViewById(R.id.et_add_form_schedule_name)
        selectTemplate = view.findViewById(R.id.tv_select_template)
        et_templateContent = view.findViewById(R.id.et_templateContent)
        min_numPicker = view.findViewById(R.id.np_frag_schedule_add_form_min)
        tv_selectedTime = view.findViewById(R.id.tv_frag_schedule_add_form_selected_time)
        calendarView = view.findViewById(R.id.calendarView_frag_schedule_calendar)
        selectMode = view.findViewById(R.id.tv_select_mode_template)
        selectContactSchedule = view.findViewById(R.id.tv_frag_cont_add_contact_to_schedule)
        iv_mode_template = view.findViewById(R.id.iv_select_mode_template)
        tv_rule_Of_scheduler = view.findViewById(R.id.tv_rule_Of_scheduler)
        iv_rule_Of_scheduler_dropdown = view.findViewById(R.id.iv_rule_Of_scheduler_dropdown)
        iv_frag_cont_add_schedule_to = view.findViewById(R.id.iv_frag_cont_add_schedule_to)
        cv_frag_Shceduler_add_submit = view.findViewById(R.id.cv_frag_Shceduler_add_submit)

        iv_template = view.findViewById(R.id.iv_frag_sched_add_form_template_dropDown)
        selectTemplate.isEnabled = false
        selectMode.isEnabled = false
        tv_rule_Of_scheduler.isEnabled = false
        selectContactSchedule.isEnabled = false


        iv_template.setOnClickListener(this)
        iv_mode_template.setOnClickListener(this)
        iv_rule_Of_scheduler_dropdown.setOnClickListener(this)
        iv_frag_cont_add_schedule_to.setOnClickListener(this)
        cv_frag_Shceduler_add_submit.setOnClickListener(this)

        setCal()
        setTestData()
        setModeData()
        setRuleData()
    }

    private fun setCal(){
        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE)

        /*val currentDate = AppUtils.getCurrentDateChanged()
        var y = currentDate.split("-").get(2).toInt()
        var m = currentDate.split("-").get(1).toInt()
        var d = currentDate.split("-").get(0).toInt()*/

        calendarView.state().edit()
            .setMinimumDate(CalendarDay.today())
            //.setMaximumDate(CalendarDay.today())
            .commit()

        hour_numPicker.minValue = 0
        hour_numPicker.maxValue = 23
        min_numPicker.minValue = 0
        min_numPicker.maxValue = 59

        var hrL = Array<String>(24) { "" }
        for(i in 0..23){
            hrL[i] = "${i} h"
        }
        var minL = Array<String>(60) { "" }
        for(i in 0..59){
            minL[i] = "${i} min"
        }

        hour_numPicker.displayedValues =hrL
        min_numPicker.displayedValues =minL

        var selectedHr = "0 h"
        var selectedMin = "0 min"

        cv_calendar.visibility = View.GONE
        sw_repeatmonth.visibility = View.GONE


        hour_numPicker.setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
            override fun onValueChange(numberPicker: NumberPicker, i: Int, i2: Int) {
                try{
                    selectedHr = hrL[i2].toString()
                    tv_selectedTime.text = selectedHr+" "+ selectedMin
                    if (tv_selectedTime.text.toString().equals("0 h 0 min")){
                        cv_calendar.visibility = View.GONE
                        sw_repeatmonth.visibility = View.GONE
                    }else{
                        cv_calendar.visibility = View.VISIBLE
                        sw_repeatmonth.visibility = View.VISIBLE
                    }
                }catch (ex:Exception){
                    ex.printStackTrace()
                    println("tag_picker_err ${ex.message}")
                }
            }
        })

        min_numPicker.setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
            override fun onValueChange(numberPicker: NumberPicker, i: Int, i2: Int) {
                try{
                    selectedMin = minL[i2].toString()
                    tv_selectedTime.text =selectedHr+" "+ selectedMin
                    if (tv_selectedTime.text.toString().equals("0 h 0 min")){
                        cv_calendar.visibility = View.GONE
                        sw_repeatmonth.visibility = View.GONE
                    }else{
                        cv_calendar.visibility = View.VISIBLE
                        sw_repeatmonth.visibility = View.VISIBLE
                    }
                }catch (ex:Exception){
                    ex.printStackTrace()
                    println("tag_picker_err ${ex.message}")
                }
                var t = calendarView.selectedDates
                var a = "as"
            }
        })

    }


    private fun setTemplateData(){
        var templateList =  AppDatabase.getDBInstance()?.scheduleTemplateDao()?.getAll() as ArrayList<ScheduleTemplateEntity>
        if(templateList.size>0){
            var genericL : ArrayList<CustomData> = ArrayList()
            for(i in 0..templateList.size-1){
                genericL.add(CustomData(templateList.get(i).template_id.toString(),templateList.get(i).template_name.toString()))
            }
            GenericDialog.newInstance("Template",genericL as ArrayList<CustomData>){

            }.show((mContext as DashboardActivity).supportFragmentManager, "")
        }else{
            Toaster.msgShort(mContext, "No Template Found")
        }
    }

    private fun setTestData(){
        var obj = ScheduleTemplateEntity()
        obj.template_id = 1
        obj.template_name = "Manual"

        var obj1 = ScheduleTemplateEntity()
        obj1.template_id = 2
        obj1.template_name = "Other"

        AppDatabase.getDBInstance()?.scheduleTemplateDao()?.insert(obj)
        AppDatabase.getDBInstance()?.scheduleTemplateDao()?.insert(obj1)
    }

    private fun setModeData(){
        var objMode1 = ModeTemplateEntity()
        objMode1.mode_template_id = 1
        objMode1.mode_template_name = "WhatsApp"

        var objMode2 = ModeTemplateEntity()
        objMode2.mode_template_id = 2
        objMode2.mode_template_name = "Email"

        AppDatabase.getDBInstance()?.modeTemplateDao()?.insert(objMode1)
        AppDatabase.getDBInstance()?.modeTemplateDao()?.insert(objMode2)
    }

    private fun setRuleData(){
        var objRule1 = RuleTemplateEntity()
        objRule1.rule_template_id = 1
        objRule1.rule_template_name = "Auto"

        var objRule2 = RuleTemplateEntity()
        objRule2.rule_template_id = 2
        objRule2.rule_template_name = "Manual"

        AppDatabase.getDBInstance()?.ruleTemplateDao()?.insert(objRule1)
        AppDatabase.getDBInstance()?.ruleTemplateDao()?.insert(objRule2)
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_frag_sched_add_form_template_dropDown->{
                if((AppDatabase.getDBInstance()?.scheduleTemplateDao()?.getAll() as ArrayList<ScheduleTemplateEntity>).size>0){
                    loadTemplateList(AppDatabase.getDBInstance()?.scheduleTemplateDao()?.getAll() as ArrayList<ScheduleTemplateEntity>)
                }else{
                    Toast.makeText(mContext, "No data found", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.iv_select_mode_template->{
                if((AppDatabase.getDBInstance()?.modeTemplateDao()?.getAll() as ArrayList<ModeTemplateEntity>).size>0){
                    loadModeOfTemplateList(AppDatabase.getDBInstance()?.modeTemplateDao()?.getAll() as ArrayList<ModeTemplateEntity>)
                }else{
                    Toast.makeText(mContext, "No data found", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.iv_rule_Of_scheduler_dropdown->{
                if((AppDatabase.getDBInstance()?.modeTemplateDao()?.getAll() as ArrayList<ModeTemplateEntity>).size>0){
                    loadRuleOfTemplateList(AppDatabase.getDBInstance()?.ruleTemplateDao()?.getAll() as ArrayList<RuleTemplateEntity>)
                }else{
                    Toast.makeText(mContext, "No data found", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.iv_frag_cont_add_schedule_to->{
                var contL = AppDatabase.getDBInstance()!!.addShopEntryDao().getContatcShopsByAddedDate() as ArrayList<AddShopDBModelEntity>
                if(contL.size >0){
                    loadContactOfTemplateList(contL)
                } else{
                    Toast.makeText(mContext, "No data found", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cv_frag_Shceduler_add_submit ->{
                AppUtils.hideSoftKeyboard(mContext as DashboardActivity)
                    submitValidationCheck()

            }

        }
    }

    private fun submitValidationCheck() {

        progress_wheel.spin()

        if(schedulername.text.toString().length==0 || schedulername.text.toString().trim().equals("")){
            schedulername.requestFocus()
            schedulername.setError("Enter Scheduler Name")
            progress_wheel.stopSpinning()
            return
        }
        if(schedulername.text.toString().trim().matches("^(?![0-9._])(?!.*[0-9._]\$)(?!.*\\d_)(?!.*_\\d)[a-zA-Z0-9_]+\$".toRegex())){
            schedulername.requestFocus()
            schedulername.setError("Enter currect Scheduler Name")
            progress_wheel.stopSpinning()
            return
        }
        if(selectTemplate.text.toString().length==0 || selectTemplate.text.toString().trim().equals("")){
            selectTemplate.requestFocus()
            selectTemplate.setError("Select a template")
            progress_wheel.stopSpinning()
            return
        }
        if (!selectTemplate.text.toString().equals("Manual")){
            et_templateContent.isEnabled =false
        }else{
            et_templateContent.isEnabled =true
        }
        if(et_templateContent.text.toString().length==0 || et_templateContent.text.toString().trim().equals("")){
            et_templateContent.requestFocus()
            et_templateContent.setError("Write template content")
            progress_wheel.stopSpinning()
            return
        }
        if(et_templateContent.text.toString().length>1000){
            et_templateContent.requestFocus()
            et_templateContent.setError("Write template content within 1000 word")
            progress_wheel.stopSpinning()
            return
        }
        if(selectMode.text.toString().length==0 || selectMode.text.toString().trim().equals("")){
            selectMode.requestFocus()
            selectMode.setError("Select a mode")
            progress_wheel.stopSpinning()
            return
        }
        if(tv_rule_Of_scheduler.text.toString().length==0 || tv_rule_Of_scheduler.text.toString().trim().equals("")){
            tv_rule_Of_scheduler.requestFocus()
            tv_rule_Of_scheduler.setError("Select a rule")
            progress_wheel.stopSpinning()
            return
        }
        if (!tv_rule_Of_scheduler.text.toString().equals("Manual")){
            cv_calendar.visibility = View.GONE
            sw_repeatmonth.visibility = View.GONE
        }else{
            cv_calendar.visibility = View.VISIBLE
            sw_repeatmonth.visibility = View.VISIBLE
        }

    }


    private fun loadTemplateList(schedule_list:ArrayList<ScheduleTemplateEntity>) {
        if (schedule_list.size>0) {
            var genericL : ArrayList<CustomData> = ArrayList()
            for(i in 0..schedule_list.size-1){
                genericL.add(CustomData(schedule_list.get(i).template_id.toString(),schedule_list.get(i).template_name.toString()))
            }
            GenericDialog.newInstance("Template",genericL as ArrayList<CustomData>){
                selectTemplate.setText(it.name)
                str_templateID = it.id
            }.show((mContext as DashboardActivity).supportFragmentManager, "")
        } else {
            Toaster.msgShort(mContext, "No Template Found")
        }

    }

    private fun loadModeOfTemplateList(mode_list:ArrayList<ModeTemplateEntity>) {
        if (mode_list.size>0) {
            var genericL : ArrayList<CustomData> = ArrayList()
            for(i in 0..mode_list.size-1){
                genericL.add(CustomData(mode_list.get(i).mode_template_id.toString(),mode_list.get(i).mode_template_name.toString()))
            }
            GenericDialog.newInstance("Mode of Template",genericL as ArrayList<CustomData>){
                selectMode.setText(it.name)
                str_modeoftemplateID = it.id
            }.show((mContext as DashboardActivity).supportFragmentManager, "")
        } else {
            Toaster.msgShort(mContext, "No Mode Found")
        }

    }

    private fun loadRuleOfTemplateList(rule_list:ArrayList<RuleTemplateEntity>) {
        if (rule_list.size>0) {
            var genericL : ArrayList<CustomData> = ArrayList()
            for(i in 0..rule_list.size-1){
                genericL.add(CustomData(rule_list.get(i).rule_template_id.toString(),rule_list.get(i).rule_template_name.toString()))
            }
            GenericDialog.newInstance("Rule of Template",genericL as ArrayList<CustomData>){
                tv_rule_Of_scheduler.setText(it.name)
                str_ruleoftemplateID = it.id
            }.show((mContext as DashboardActivity).supportFragmentManager, "")
        } else {
            Toaster.msgShort(mContext, "No Rule Found")
        }

    }
    private fun loadContactOfTemplateList(contact_list:ArrayList<AddShopDBModelEntity>) {
        if (contact_list.size>0) {
            var genericL : ArrayList<CustomData> = ArrayList()
            for(i in 0..contact_list.size-1){
               // AppDatabase.getDBInstance()?.addShopEntryDao()?.deleteAll()
                genericL.add(CustomData(contact_list.get(i).shop_id.toString(),contact_list.get(i).shopName.toString()))
            }
            GenericDialog.newInstance("Contact of Template",genericL as ArrayList<CustomData>){
                selectContactSchedule.setText(it.name)
                str_contactoftemplateID = it.id
            }.show((mContext as DashboardActivity).supportFragmentManager, "")
        } else {
            Toaster.msgShort(mContext, "No Contact Found")
        }

    }

}
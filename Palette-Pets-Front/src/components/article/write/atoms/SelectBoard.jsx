import React, { memo, useEffect, useMemo, useState } from 'react';
import CssBaseline from "@mui/material/CssBaseline";
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';




const communityBoardList = [

    { idx: 1, boardName: '자유게시판', boardValue: 'FREEBOARD' },
    { idx: 2, boardName: '정보게시판', boardValue: 'INFORMATION' },
    { idx: 3, boardName: '자랑게시판', boardValue: 'SHOW' },
    { idx: 4, boardName: '질문게시판', boardValue: 'QNA' }

]

const storeBoardList =[

    { idx: 1, boardName: '구매 등록', boardValue: 'BUY' },
    { idx: 2, boardName: '판매 등록', boardValue: 'SELL' },
    { idx: 3, boardName: '나눔 등록', boardValue: 'SHARE' },
    { idx: 4, boardName: '산책 등록', boardValue: 'WALKING' }

]

const SelectBoard = memo(({boardName,onChange}) => {
   
    return (
        <>
      
                <FormControl sx={{ m: 2, width: "80%" }}>
                    <InputLabel id="select-board">게시판 선택</InputLabel>
                    <Select
                        labelId="select-board"
                        id="select-board"
                        name="boardName"
                        value={`${boardName}`}
                        inputProps={{ MenuProps: { disableScrollLock: true } }}
                        label="게시판 선택"
                        onChange={onChange}
                    >
                        <MenuItem value='FREEBOARD'>자유게시판</MenuItem>
                        <MenuItem value='INFORMATION'>정보게시판</MenuItem>
                        <MenuItem value='SHOW'>자랑게시판</MenuItem>
                        <MenuItem value='QNA'>질문게시판</MenuItem>
                        
                    </Select>
                </FormControl>
               
                
           
        </>
    );
});

export default SelectBoard;
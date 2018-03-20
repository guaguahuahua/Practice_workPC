package com.xjtu.matrix;

public class Matrix implements Cloneable {
	//�������������������
	public int rowAll;
	public int colAll;
	//����Ԫ������
	public int dataAll;
	public TriElement[] elements;
	
	public Matrix() {
		this.rowAll=0;
		this.colAll=0;
		this.dataAll=0;
		elements=new TriElement[5];
		for(int i=0; i<5; i++) {
			elements[i]=new TriElement();
		}
	}
	
	/**
	 * ��������������ʼ��
	 * @param nums int[][]
	 */
	public void init(int [][]nums) {
		//��ʼ������������
		this.rowAll=nums.length;
		this.colAll=nums[0].length;
		
		for(int row=0; row<nums.length; row++) {
			for(int col=0; col<nums[0].length; col++) {
				//��ʼ�����յķ���Ԫ����������Ԫ�ط��õ�
				if(nums[row][col]!=0) {
					elements[dataAll].data=nums[row][col];
					elements[dataAll].row=row;
					elements[dataAll].col=col;
					this.dataAll++;
					//��̬��������ṹ
					if(dataAll>=elements.length) {
						elements=enlarge(elements);
					}
				}
			}
		}
	}
	
	/**
	 * ��������
	 * @param elements
	 * @return
	 */
	public static TriElement[] enlarge(TriElement []elements) {
		int delta=10;
		TriElement []e=new TriElement[elements.length+delta];
		for(int i=0; i<e.length; i++) {
			if(i<elements.length) {
				e[i]=elements[i];
			}else {
				e[i]=new TriElement();
			}
			
		}
		elements=e;
		return elements;
	}
	
	/**
	 * ת��
	 * @param ma	Matrix	ת��ǰ
	 * @param mb	Matrix	ת�ú�
	 */
	public void trans(Matrix ma, Matrix mb) {
		mb.rowAll=ma.colAll;
		mb.colAll=ma.rowAll;
		mb.dataAll=ma.dataAll;
		
		if(ma.dataAll==0) {
			return ;
		}else {
			for(int v=0; v<ma.dataAll; v++) {
				//����ԭʼ��Ԫ��
				for(int a=0; a<ma.dataAll; a++) {
					if(ma.elements[a].col==v) {
						mb.elements[v].row=ma.elements[a].col;
						mb.elements[v].col=ma.elements[a].row;
						mb.elements[v].data=ma.elements[a].data;
					}			
				}
			}
		}		
	}
	
	public void show(TriElement[] elements) {
		for(int i=0; i<dataAll; i++) {
			System.out.println(elements[i].row+", "+elements[i].col+", "+elements[i].data);
		}
	}
	
	public Matrix clone() {
		Matrix m=null;
		try {
			m=(Matrix) super.clone();
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		m.rowAll=this.rowAll;
//		m.colAll=this.colAll;
//		m.dataAll=this.dataAll;
		m.elements=this.elements.clone();
		return m;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]nums= {
				{ 0, 0 , 11, 0, 17, 0, 0 },
				{ 0, 25,  0, 0,  0, 0, 0 }, 
				{ 0,  0,  0, 0,  0, 0, 0 },
				{19,  0,  0, 0,  0, 0, 0 },
				{ 0,  0,  0,37,  0, 0, 0 },
				{ 0,  0,  0, 0,  0, 0, 50 }
				};
		Matrix m=new Matrix();
		m.init(nums);
		m.show(m.elements);
		System.out.println("ת��֮��");
		Matrix mb=m.clone();
		m.trans(m, mb);
		mb.show(mb.elements);
	}
}
